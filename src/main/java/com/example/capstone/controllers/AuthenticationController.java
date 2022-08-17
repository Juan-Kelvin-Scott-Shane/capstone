package com.example.capstone.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class AuthenticationController {
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
}

