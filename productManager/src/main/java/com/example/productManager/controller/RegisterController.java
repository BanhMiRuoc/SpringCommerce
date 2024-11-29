package com.example.productManager.controller;

import com.example.productManager.model.User;
import com.example.productManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        if (userService.usernameExists(user.getUserName())) {
            return "redirect:/register?error=username_exists";
        }
        userService.registerUser(user);
        return "redirect:/login";
    }
}
