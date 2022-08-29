package com.example.capstone.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.capstone.models.User;
import com.example.capstone.repositories.UserRepository;

import java.util.List;

@Controller
public class HomeController {
    private final UserRepository userDao;

    public HomeController(UserRepository userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/")
    public String home(){
        return "index";
    }
    @GetMapping("/browse")
    public String browse(Model model){
        model.addAttribute("users", userDao.findAll());

       // model.addAttribute("instruments", user.getInstruments());
        //User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //model.addAttribute("instruments", userDao.getById(currentUser.getId()).getProficiencies());
        return "browse";
    }
    @GetMapping("/about")
    public String showAbout(){
        return"about";
    }
}
