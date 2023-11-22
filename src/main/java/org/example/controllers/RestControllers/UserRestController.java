package org.example.controllers.RestControllers;

import lombok.AllArgsConstructor;
import org.example.model.Article;
import org.example.model.User;
import org.example.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user-api")
public class UserRestController {
    private final UserService service;

    @GetMapping("/")
    public List<User> getAllUsers() {
        return service.findAllUsers();
    }

    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @PostMapping("/add")
    public User addArticle(@RequestParam(required = false) Long articleId, @RequestParam long userId, @ModelAttribute Article article) {
        if (articleId == null) {
            return service.addArticle(userId, article);
        }
        return service.addArticle(userId, articleId);
    }
    @GetMapping(value = "/photo/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public byte[] getPhoto(@PathVariable Long id) {
        return service.getPhoto(id);
    }
}
