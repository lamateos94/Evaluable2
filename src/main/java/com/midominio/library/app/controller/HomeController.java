package com.midominio.library.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping({"","/home","/"})
	public String homeHandler(Model model) {
		
		model.addAttribute("title", "Home");
		model.addAttribute("header", "Books and users management");
		
		return "/home";
	}
	
}
