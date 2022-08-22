package com.example.capstone.controllers;

import com.example.capstone.models.Event;
import com.example.capstone.repositories.EventRepository;
import com.example.capstone.repositories.UserRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class EventController {

    private final EventRepository eventDao;
    private final UserRepository userDao;

    public EventController(EventRepository eventDao, UserRepository userDao) {
        this.eventDao = eventDao;
        this.userDao = userDao;
    }
    @GetMapping("/events")
    public String showEvent(Model model){
    List<Event>all =  eventDao.findAll();
    model.addAttribute("event", all);
    return "/event";

    }
    @GetMapping("/event/show/{id}")
    public String showEventId(@PathVariable long id, Model model){
        model.addAttribute("event",eventDao.getById(id));
        return"/event/show";
    }

    @GetMapping("/events/create")
    public String showCreationForm(Model model){
        model.addAttribute("event",new Event());
        return "/event/create";
    }
    @PostMapping("/events/create")
    public String create(@ModelAttribute Event event, @RequestParam long id){
        eventDao.save(event);
        return "/events";


    }
}
