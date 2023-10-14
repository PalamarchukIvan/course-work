package org.example.controllers;

import lombok.AllArgsConstructor;
import org.example.model.Article;
import org.example.model.User;
import org.example.services.ArticleService;
import org.example.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@RequestMapping("/main")
public class ArticleController {
    public ArticleService articleService;
    private final UserService userService;

    @GetMapping("/")
    public String getAllArticles(Model model) {
        model.addAttribute("articles", articleService.findAllArticles());
        return "main-page";
    }

    @GetMapping("/create")
    public String createNewArticle(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userDetails = (User) authentication.getPrincipal();
        Long id = userDetails.getId();
        model.addAttribute("userId", id);
        return "article-builder";
    }
//    @PostMapping("/add")
    public String addArticle(@RequestParam long userId, @ModelAttribute Article article) {
        userService.addArticle(userId, article);
        return "redirect:../main/";
    }
}
