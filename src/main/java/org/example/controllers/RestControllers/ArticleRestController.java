package org.example.controllers.RestControllers;

import lombok.AllArgsConstructor;
import org.example.dto.ArticleDto;
import org.example.mapper.ArticleMapper;
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
    public List<ArticleDto> getAllArticles() {
        return ArticleMapper.toDto(service.findAllArticles());
    }
    @PostMapping("/")
    public ArticleDto createArticle(@RequestBody Article article) {
        return ArticleMapper.toDto(service.createArticle(article));
    }
}
