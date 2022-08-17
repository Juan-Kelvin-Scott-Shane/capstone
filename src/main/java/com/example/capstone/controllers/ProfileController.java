package com.example.capstone.controllers;

import com.example.capstone.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProfileController {
    private final UserRepository userDao;

    public ProfileController(UserRepository userDao) {
        this.userDao = userDao;
    }



    @RequestMapping (path = "/profile", method = RequestMethod.GET)
    public String viewProfile(){
        return "profile";
    }

    @GetMapping("/profile/{id}/edit")
    public String editProfile(Model model,@PathVariable long id){

        return"profile";

    }




}
