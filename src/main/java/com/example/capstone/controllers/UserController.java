package com.example.capstone.controllers;

import com.example.capstone.models.User;
import com.example.capstone.repositories.UserRepository;
import com.example.capstone.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

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

	@Autowired
	private UserServices service;

	@PostMapping("/register")
	public String processRegister(User user, HttpServletRequest request)
			throws UnsupportedEncodingException, MessagingException {
		service.register(user, getSiteURL(request));
		return "reg-conf";
	}

	private String getSiteURL(HttpServletRequest request) {
		String siteURL = request.getRequestURL().toString();
		return siteURL.replace(request.getServletPath(), "");
	}

	@GetMapping("/verify")
	public String verifyUser(@Param("code") String code) {
		if (service.verify(code)) {
			return "verify_success";
		} else {
			return "verify_fail";
		}
	}
}