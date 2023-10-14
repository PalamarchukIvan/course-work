package org.example.controllers;

import lombok.AllArgsConstructor;
import org.example.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/web")
public class UserController {
    private final UserService service;
    @GetMapping("/")
    public String getHomeAllUsers(Model model) {
        model.addAttribute("users", service.findAllUsers());
        return "home";
    }
}
