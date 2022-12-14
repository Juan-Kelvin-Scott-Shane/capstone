package com.example.capstone.controllers;

import com.example.capstone.models.Event;
import com.example.capstone.models.User;
import com.example.capstone.repositories.EventRepository;
import com.example.capstone.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

@Controller
public class EventController {

    private final EventRepository eventDao;
    private final UserRepository userDao;

    @Value("${spring.file.api}")
    private String fileApi;

    public EventController(EventRepository eventDao, UserRepository userDao) {
        this.eventDao = eventDao;
        this.userDao = userDao;
    }

    @GetMapping("/events")
    public String showEvent(Model model) {
        List<Event> all = eventDao.findAll();
        model.addAttribute("events", all);
        try {
            User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("currentUser", currentUser);
        } catch (Exception e) {
            return "all-events";
        }
        return "all-events";
    }

    @GetMapping("/event/show/{id}")
    public String showEventId(@PathVariable long id, Model model) {
        model.addAttribute("event", eventDao.getById(id));
        return "events/show";
    }

    @GetMapping("/events/create")
    public String showCreationForm(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("fileApi", fileApi);
        return "create-event";
    }

    @PostMapping("/events/create")
    public String create(@ModelAttribute Event event, @RequestParam String date, @RequestParam String time) throws ParseException {
        String[] dateParts = date.split("-");
        String year = dateParts[0];
        String month = dateParts[1];
        String day = dateParts[2];
        String finalDate = String.format("%s/%s/%s", month, day, year);
        String[] timeParts = time.split(":");
        String hour = timeParts[0];
        String minutes = timeParts[1];
        String finalTime = String.format("%s:%s", hour, minutes);
        event.setTime(finalTime);
        event.setDate(finalDate);
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        event.setOwner(currentUser);
        event.setState(event.getState().toUpperCase());
        eventDao.save(event);
        return "redirect:/events";
    }

    @GetMapping("/events/{id}/edit")
    public String editPost(Model model, @PathVariable long id) {
        Event event = eventDao.getById(id);
        model.addAttribute("fileApi", fileApi);
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (currentUser.getId() == event.getOwner().getId()) {
            String date = eventDao.getById(id).getDate();
            String[] dateParts = date.split("/");
            String year = dateParts[2];
            String month = dateParts[0];
            String day = dateParts[1];
            String finalDate = String.format("%s-%s-%s", year, month, day);
            event.setDate(finalDate);
            event.setState(event.getState().toUpperCase());
            model.addAttribute("event", event);
        }
        return "edit-event";
    }

    @PostMapping("/events/{id}")
    public String deletePost(Model model,@PathVariable Long id) {
        Event event = eventDao.getById(id);
        try{
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(currentUser.getId() == event.getOwner().getId()) {
            model.addAttribute("currentUser",currentUser);
            eventDao.deleteById(id);
            return "redirect:/events";
        }
        }catch(Exception e){
                System.out.println("Doesn't work");
            return "redirect:/events";
            }
        return "redirect:/events";
    }

    @PostMapping("/events/search")
    public String searchUsers(HttpServletRequest request, Model model) {
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String date = String.valueOf(request.getParameter("date"));
        String[] dateParts = date.split("-");
        String year = dateParts[0];
        String month = dateParts[1];
        String day = dateParts[2];
        String finalDate = String.format("%s/%s/%s", month, day, year);
        List<Event> returnedEvents;
        returnedEvents = eventDao.findEventsByCityContainingAndStateAndDate(city, state, finalDate);
        if (!returnedEvents.isEmpty()) {
            model.addAttribute("events", returnedEvents);
            return "all-events";
        } else {
            model.addAttribute("events", returnedEvents);
            return "redirect:/events?noresults";
        }
    }
}
