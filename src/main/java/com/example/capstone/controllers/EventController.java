package com.example.capstone.controllers;

import com.example.capstone.models.Event;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class EventController {
    @GetMapping("/events/create")
    public String showCreationForm(Model model){
        model.addAttribute("event",new Event());
        return "/event/create";

    }
}
