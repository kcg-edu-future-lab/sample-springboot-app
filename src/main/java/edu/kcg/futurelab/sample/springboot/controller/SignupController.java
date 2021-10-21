package edu.kcg.futurelab.sample.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.kcg.futurelab.sample.springboot.service.UserService;

@Controller
@RequestMapping("/signup")
public class SignupController {
	@Autowired
	private UserService userService;

	@GetMapping
	public String getSignupPage(){
		return "signup";
	}

	@PostMapping
	public String signup(
			@RequestParam String username,
			@RequestParam String displayName,
			@RequestParam String password) {
		userService.addUser(username, displayName, password);
		return "redirect:/login";
	}
}
