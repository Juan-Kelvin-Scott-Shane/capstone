package com.example.capstone.controllers;

import com.example.capstone.models.Event;
import com.example.capstone.models.User;
import com.example.capstone.repositories.EventRepository;
import com.example.capstone.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
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
    return "events/index";

    }
    @GetMapping("/event/show/{id}")
    public String showEventId(@PathVariable long id, Model model){
        model.addAttribute("event",eventDao.getById(id));
        return"events/show";
    }

    @GetMapping("/events/create")
    public String showCreationForm(Model model){
        model.addAttribute("event",new Event());
        return "/events/create";
    }
    @PostMapping("/events/create")
    public String create(@ModelAttribute Event event, @RequestParam long id, @RequestParam String date) throws ParseException {
//        if (dateContainer.getDateTime() == null) {
//            dateContainer.setDateTime(LocalDateTime.now());
//        event.setOwner(userDao.getById(id));
        DateFormat df = new SimpleDateFormat();
        Date localDate = df.parse(date);
        System.out.println(localDate);
        event.setDate(localDate);
        eventDao.save(event);
        return "redirect:/events";
    }
}
