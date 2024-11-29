package com.example.productManager.controller;

import com.example.productManager.model.User;
import com.example.productManager.repository.UserRepository;
import com.example.productManager.service.CustomUserService;
import com.example.productManager.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Xác thực người dùng
        User user = userRepository.findByUserName(username).orElse(null);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return "redirect:/product"; // Chuyển hướng đến trang sản phẩm
        } else {
            return "redirect:/login?error=true";
        }
    }


}
