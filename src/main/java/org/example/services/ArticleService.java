package org.example.services;

import lombok.AllArgsConstructor;
import org.example.model.Article;
import org.example.model.User;
import org.example.repository.ArticleRepository;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ArticleService {
    private final ArticleRepository repository;
    private final UserRepository userRepository;
    @Transactional
    public Article createArticle(Article article) {
        return repository.save(article);
    }
    @Transactional(readOnly = true)
    public List<Article> findAllArticles() {
        return repository.findAll();
    }
    @Transactional(readOnly = true)
    public Article findArticleById(long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<Article> findAllArticlesWithUser(long userId) {
        return repository.findByAuthor_Id(userId);
    }

    public Article addLike(long articleId, long userId) {
        Article article = findArticleById(articleId);
        User user = userRepository.findById(userId).orElseThrow();

        article.getLikes().add(user);
        return repository.save(article);
    }
    public void deleteArticle(long id) {
        repository.delete(findArticleById(id));
    }
}
