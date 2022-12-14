package com.example.capstone.controllers;


import com.example.capstone.models.Proficiency;
import com.example.capstone.models.User;
import com.example.capstone.repositories.ProficiencyRepository;
import com.example.capstone.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;


@Controller
public class ProfileController {
	private final UserRepository userDao;
	private final ProficiencyRepository proficiencyDao;

	@Value("${spring.file.api}")
	private String fileApi;

	public ProfileController(UserRepository userDao, ProficiencyRepository proficiencyDao) {
		this.userDao = userDao;
		this.proficiencyDao = proficiencyDao;
	}

	@GetMapping("/profile")
	public String viewProfile(Model model, User user) {
		try {
			User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userState = currentUser.getState();
			model.addAttribute("instruments", userDao.getById(currentUser.getId()).getProficiencies());
			model.addAttribute("newProficiency", new Proficiency());
			model.addAttribute("fileApi", fileApi);
			model.addAttribute("userState", userState);
			return "profile";
		} catch (Exception e) {
			System.out.println("Doesn't work");
			return "redirect:/login";
		}
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

	@PostMapping("/profile/delinst")
	public String delInst(HttpServletRequest request, Model model, Proficiency proficiency) {
		String instrument = request.getParameter("delinst");
		proficiencyDao.deleteById(Long.valueOf(instrument));
		return "redirect:/profile";
	}

	@PostMapping("/profile/editBio")
	public String editBio( User user){
		User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		user.setUsername(currentUser.getUsername());
		user.setUserType(currentUser.getUserType());
		user.setEmail(currentUser.getEmail());
		user.setEnabled(currentUser.isEnabled());
		user.setPassword(currentUser.getPassword());
		user.setDescription(currentUser.getDescription());
		user.setSocial_media(currentUser.getSocial_media());
		user.setYoutube(currentUser.getYoutube());
		user.setId(currentUser.getId());
		user.setProfile_img(currentUser.getProfile_img());
		userDao.save(user);
		final Authentication oldAuth = SecurityContextHolder.getContext().getAuthentication();
		final Authentication newAuth = new PreAuthenticatedAuthenticationToken(user, oldAuth.getCredentials(), oldAuth.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(newAuth);
		return "redirect:/profile";
	}

	@PostMapping("/profile/editDescription")
	public String editDescription(User user){
		User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		user.setUsername(currentUser.getUsername());
		user.setUserType(currentUser.getUserType());
		user.setEmail(currentUser.getEmail());
		user.setState(currentUser.getState());
		user.setCity(currentUser.getCity());
		user.setEnabled(currentUser.isEnabled());
		user.setPassword(currentUser.getPassword());
		user.setCity(currentUser.getCity());
		user.setState(currentUser.getState());
		user.setId(currentUser.getId());
		user.setProfile_img(currentUser.getProfile_img());
		userDao.save(user);
		final Authentication oldAuth = SecurityContextHolder.getContext().getAuthentication();
		final Authentication newAuth = new PreAuthenticatedAuthenticationToken(user, oldAuth.getCredentials(), oldAuth.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(newAuth);
		return "redirect:/profile";
	}

	@PostMapping("/profile/editimg")
	public String editimg( User user){
		User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		user.setUsername(currentUser.getUsername());
		user.setUserType(currentUser.getUserType());
		user.setEmail(currentUser.getEmail());
		user.setState(currentUser.getState());
		user.setCity(currentUser.getCity());
		user.setEnabled(currentUser.isEnabled());
		user.setPassword(currentUser.getPassword());
		user.setDescription(currentUser.getDescription());
		user.setSocial_media(currentUser.getSocial_media());
		user.setYoutube(currentUser.getYoutube());
		user.setId(currentUser.getId());
		userDao.save(user);
		final Authentication oldAuth = SecurityContextHolder.getContext().getAuthentication();
		final Authentication newAuth = new PreAuthenticatedAuthenticationToken(user, oldAuth.getCredentials(), oldAuth.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(newAuth);
		return "redirect:/profile";
	}

}
