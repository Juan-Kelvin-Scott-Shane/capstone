package com.example.capstone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "index";
    }
    @GetMapping("/browse")
    public String browse(){
        return "browse";
    }
    @GetMapping("/about")
    public String showAbout(){
        return"about";
    }
}