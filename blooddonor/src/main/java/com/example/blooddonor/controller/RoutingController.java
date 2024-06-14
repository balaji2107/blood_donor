package com.example.blooddonor.controller;

import com.example.blooddonor.model.Eligible;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class RoutingController {
	
	@RequestMapping("/index")
	public String index() {
		return "redirect:/bdonor?fragmentToLoad=main";
	}

	@RequestMapping("/register")
	public String register() {
		return "register";
	}

	@RequestMapping("/home")
	public String home(@RequestParam(name = "fragmentToLoad") String fragmentToLoad,Model model, HttpSession session) {
		Object getEligible=model.asMap().get("userEligible");
		if(getEligible!=null) {
			Eligible eligible=(Eligible)getEligible;
			model.addAttribute("eligibles", eligible);
		}
		session.setAttribute("role", "donor");
		model.addAttribute("fragmentToLoad", fragmentToLoad);
		return "home";
	}

	@RequestMapping("/bdonor")
	public String donorIndex(@RequestParam(name = "fragmentToLoad") String fragmentToLoad,Model model,HttpSession session) {
		model.addAttribute("fragmentToLoad", fragmentToLoad);
		return "index";
	}

}
