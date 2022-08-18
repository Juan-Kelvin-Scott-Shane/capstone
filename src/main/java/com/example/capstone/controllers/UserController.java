package com.example.capstone.controllers;

import com.example.capstone.models.User;
import com.example.capstone.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String hash = passwordEncoder.encode("password");
    System.out.println(hash);
}

	private PasswordEncoder passwordEncoder;
	private UserRepository userDao;

	public UserController(PasswordEncoder passwordEncoder, UserRepository userRepository) {
		this.passwordEncoder = passwordEncoder;
		this.userDao = userRepository;
	}

	@GetMapping("/register")
	public String registrationForm(Model model) {
		model.addAttribute("newUser", new User());
		return "register";
	}

	@PostMapping("/register")
	public String registration(@ModelAttribute User user) {
		String hash = passwordEncoder.encode(user.getPassword());
		user.setPassword(hash);
		System.out.println(user.getUsername());
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		userDao.save(user);
		return "reg-conf";
	}
}