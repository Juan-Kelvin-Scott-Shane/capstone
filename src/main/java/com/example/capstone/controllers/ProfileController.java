package com.example.capstone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProfileController {
    @RequestMapping (path = "/profile", method = RequestMethod.GET)
    public String viewProfile(){
        return "profile";
    }
    @GetMapping("/login")
    public String viewLogin(){
        return "login";
    }
}
