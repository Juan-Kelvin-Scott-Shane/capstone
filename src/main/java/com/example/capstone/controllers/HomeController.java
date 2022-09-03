package com.example.capstone.controllers;

import com.example.capstone.models.Event;
import com.example.capstone.models.Genre;
import com.example.capstone.repositories.GenreRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.capstone.models.User;
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
        //Long genre2 = Long.valueOf(request.getParameter("genre2"));
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        if (usrType.equals("musician") || usrType.equals("band")) {
            Long genre1 = Long.valueOf(request.getParameter("genre1"));
            model.addAttribute("users", userDao.findUserWithGenre(genre1, usrType));
            return "browse";
        } else if (usrType.equals("venue")) {
            //model.addAttribute("users", userDao.findVenueByLocation(city, state));
            model.addAttribute("users", userDao.findUsersByCityLikeAndStateLike(city, state));
            return "browse";
        } else {
            return "browse";
        }
    }


    @GetMapping("/about")
    public String showAbout(){
        return"about";
    }
}
