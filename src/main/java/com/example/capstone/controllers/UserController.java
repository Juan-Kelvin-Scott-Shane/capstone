package com.example.capstone.controllers;

import com.example.capstone.models.User;
import com.example.capstone.repositories.UserRepository;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    private static PasswordEncoder passwordEncoder;
    private UserRepository userDao;

    public UserController(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userDao = userRepository;
    }

//    public PasswordEncoder getPasswordEncoder() {
//        return passwordEncoder;
//    }

//    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }

    public UserRepository getUserDao() {
        return userDao;
    }

    public void setUserRepository(UserRepository userDao) {
        this.userDao = userDao;
    }

    public UserController() {
    }

    @GetMapping("/register")
    public String registrationForm(Model model){
        model.addAttribute("newUser",new User());
                return "register";
    }
//    @PostMapping("/register")
//    public String registration(@ModelAttribute User user){
//        String hash =passwordEncoder.encode(user.getPassword());
//        user.setPassword(hash);
//        userDao.save(user);
//        return "redirect:/profile";
public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String hash = passwordEncoder.encode("password");
    System.out.println(hash);
}

//    }
}
