package org.example.controllers;

import lombok.AllArgsConstructor;
import org.example.model.User;
import org.example.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class RegLogController {
    private final UserService service;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String main() {
        return "greeting";
    }

    @PostMapping("/login")
    public String doLogin(User user, Model model) {
        if(service.findUserByUsername((user.getUsername())) != null){
            model.addAttribute("error", new ErrorResponseDTO("User with such username does not exists"));
            return "login";
        }
        return "redirect:/";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String doRegistration(User user, Model model) {
        if(service.findUserByUsername((user.getUsername())) != null){
            model.addAttribute("error", new ErrorResponseDTO("Such user already exists"));
            return "registration";
        }
        service.createUser(user);

        return "redirect:/";
    }
}
