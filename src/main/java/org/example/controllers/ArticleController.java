package org.example.controllers;

import lombok.AllArgsConstructor;
import org.example.services.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/main")
public class ArticleController {
    public ArticleService service;
    @GetMapping("/")
    public String getAllArticles(Model model) {
        model.addAttribute("articles", service.findAllArticles());
        return "main-page";
    }
}
