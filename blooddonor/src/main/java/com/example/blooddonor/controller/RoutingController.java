package com.example.blooddonor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class RoutingController {
	
	@RequestMapping("/login")
	public String login() {
		return "index";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "register";
	}

	@RequestMapping("/home")
	public String home(@RequestParam(name = "fragmentToLoad") String fragmentToLoad,Model model, HttpSession session) {
		boolean flag = (boolean) session.getAttribute("flag");
		session.setAttribute("role", "donor");
		model.addAttribute("flag", flag);
		model.addAttribute("fragmentToLoad", fragmentToLoad);
		return "home";
	}
	@RequestMapping("/eligibleDonor")
	public String eligibleForm(Model model, HttpSession session) {
		session.setAttribute("flag", true);
		return "redirect:/home?fragmentToLoad=profile";
	}
}
