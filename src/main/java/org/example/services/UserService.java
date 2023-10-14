package org.example.services;

import lombok.AllArgsConstructor;
import org.example.model.Article;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final ArticleService articleService;
    @Transactional
    public User createUser(User user) {
        return repository.save(user);
    }
    @Transactional(readOnly = true)
    public List<User> findAllUsers() {
        return repository.findAll();
    }
    @Transactional(readOnly = true)
    public User findUserById(long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }
    public User putUser(long id, User other) {
        User user = findUserById(id);
        user.setLogin(other.getLogin());
        user.setPassword(other.getPassword());
        return repository.save(user);
    }
    public void deleteUser(long id) {
        repository.delete(findUserById(id));
    }
    public User addArticle(long userId, Article article) {
        User user = findUserById(userId);
        user.getArticles().add(article);
        article.setAuthor(user);
        articleService.createArticle(article);
        return repository.save(user);
    }
    public User addArticle(long userId, long articleId) {
        User user = findUserById(userId);
        user.getArticles().add(articleService.findArticleById(articleId));
        return repository.save(user);
    }
}
