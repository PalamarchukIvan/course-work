package org.example.services;

import lombok.AllArgsConstructor;
import org.example.model.Article;
import org.example.repository.ArticleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ArticleService {
    private final ArticleRepository repository;
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
    public Article putArticle(long id, Article other) {
        Article article = findArticleById(id);
        article.setHeader(other.getHeader());
        article.setBody(other.getBody());
        return repository.save(article);
    }
    public void deleteArticle(long id) {
        repository.delete(findArticleById(id));
    }
}
