package edu.kcg.futurelab.sample.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.kcg.futurelab.sample.springboot.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UserService userService;

	@GetMapping()
	public String search(
			@RequestParam(value = "keyword", required = false) String keyword,
			Model model) {
		model.addAttribute("users", userService.searchUser(keyword));
		return "users/index";
	}
}
