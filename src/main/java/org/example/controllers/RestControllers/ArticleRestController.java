package org.example.controllers.RestControllers;

import lombok.AllArgsConstructor;
import org.example.model.Article;
import org.example.services.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/article-api")
public class ArticleRestController {
    private final ArticleService service;
    @GetMapping("/")
    public List<Article> getAllArticles() {
        return service.findAllArticles();
    }
    @PostMapping("/")
    public Article createArticle(@RequestBody Article article) {
        return service.createArticle(article);
    }
}
