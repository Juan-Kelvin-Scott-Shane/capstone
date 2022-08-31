package com.example.capstone.controllers;

import com.example.capstone.models.Event;
import com.example.capstone.models.User;
import com.example.capstone.repositories.EventRepository;
import com.example.capstone.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
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
        model.addAttribute("events", all);
        return "all-events";

    }
    @GetMapping("/event/show/{id}")
    public String showEventId(@PathVariable long id, Model model){
        model.addAttribute("event",eventDao.getById(id));
        return"events/show";
    }

    @GetMapping("/events/create")
    public String showCreationForm(Model model){
        model.addAttribute("event",new Event());
        return "create-event";
    }
    @PostMapping("/events/create")
    public String create(@ModelAttribute Event event, @RequestParam String date,@RequestParam String time) throws ParseException {
        String[] dateParts = date.split("-");
        String year = dateParts[0];
        String month = dateParts[1];
        String day = dateParts[2];
        String finalDate = String.format("%s/%s/%s", month, day, year);
        String[]timeParts = time.split(":");
        String hour = timeParts[0];
        String minutes= timeParts[1];
        String finalTime = String.format("%s:%s",hour,minutes);
        event.setTime(finalTime);
        event.setDate(finalDate);
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        event.setOwner(currentUser);
        eventDao.save(event);
        return "redirect:/events";
    }
}