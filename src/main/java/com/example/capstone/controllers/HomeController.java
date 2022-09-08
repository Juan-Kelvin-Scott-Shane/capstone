package com.example.capstone.controllers;


import com.example.capstone.models.Event;
import com.example.capstone.models.Genre;
import com.example.capstone.models.User;
import com.example.capstone.repositories.GenreRepository;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.capstone.repositories.UserRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

@Controller
public class HomeController {
    private final UserRepository userDao;
    private final GenreRepository genreDao;

    public HomeController(UserRepository userDao, GenreRepository genreDao) {
        this.userDao = userDao;
        this.genreDao = genreDao;


    }

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/browse")
    public String browse(Model model){
        model.addAttribute("users", userDao.findAll());


        return "browse";
    }

    @PostMapping("/browse/search")
    public String searchUsers(HttpServletRequest request, Model model) {
        String usrType = request.getParameter("usrType");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        switch (usrType) {
            case "musician":
                Long genre1 = Long.valueOf(request.getParameter("genre1"));
                List<User> returnedMusician;
                returnedMusician = userDao.findUserWithGenre(genre1, usrType);
                if (!returnedMusician.isEmpty()) {
                    model.addAttribute("users", returnedMusician);
                    return "browse";
                } else {
                return "redirect:/browse?noresults";
            }
            case "band":
                Long genre2 = Long.valueOf(request.getParameter("genre2"));
                List<User> returnedBands;
                returnedBands = userDao.findUserWithGenre(genre2, usrType);
                if (!returnedBands.isEmpty()) {
                    model.addAttribute("users", returnedBands);
                    return "browse";
                } else {
                    return "redirect:/browse?noresults";
                }
            case "venue":
                List<User> returnedVenues;
                returnedVenues = userDao.findUsersByCityLikeAndStateLike(city, state);
                if (!returnedVenues.isEmpty()) {
                    model.addAttribute("users", returnedVenues);
                    return "browse";
                } else {
                    return "redirect:/browse?noresults";
                }
            default:
                return "browse";
        }
    }


    @GetMapping("/about")
    public String showAbout(){
        return"about";
    }
}
