package com.example.capstone.controllers;


import com.example.capstone.models.User;
import com.example.capstone.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class ProfileController {
    private final UserRepository userDao;

    public ProfileController(UserRepository userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/profile")
    public String viewProfile(Model model){
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("instument", currentUser.getInstruments());
        currentUser.getInstruments();
        return "profile";
    }

    @GetMapping("/profile/{id}/edit")
    public String editProfile(Model model,@PathVariable long id){
        return"profile";
    }
}
