package com.example.capstone.controllers;


import com.example.capstone.models.Proficiency;
import com.example.capstone.models.User;
import com.example.capstone.repositories.EventRepository;
import com.example.capstone.repositories.ProficiencyRepository;
import com.example.capstone.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller
public class ProfileController {
	private final UserRepository userDao;
	private final ProficiencyRepository proficiencyDao;

	public ProfileController(UserRepository userDao, ProficiencyRepository proficiencyDao) {
		this.userDao = userDao;
		this.proficiencyDao = proficiencyDao;
	}

	@GetMapping("/profile")
	public String viewProfile(Model model) {
		User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("instruments", userDao.getById(currentUser.getId()).getProficiencies());
		model.addAttribute("newProficiency", new Proficiency());
		return "profile";
	}

	@RequestMapping(path = "/profile/{username}", method = RequestMethod.GET)
	public String postPage(@PathVariable String username, Model model) {
		model.addAttribute("user", userDao.findByUsername(username));
		return "usrprofiles";
	}

	@PostMapping("/profile/contact")
	public String userContact(HttpServletRequest request, Model model) {
		User toUser = userDao.getById(Long.valueOf(request.getParameter("toUser")));
		model.addAttribute("toUser", toUser);
		model.addAttribute("subject", request.getParameter("subject"));
		return "contact";
	}

	@PostMapping("/profile/addinst")
	public String addInst(HttpServletRequest request, Model model, Proficiency proficiency) {
		User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		proficiency.setUser(currentUser);
		proficiencyDao.save(proficiency);
		return "redirect:/profile";
	}

}
