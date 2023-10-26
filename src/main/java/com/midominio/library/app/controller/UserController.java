package com.midominio.library.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.midominio.library.app.entity.User;
import com.midominio.library.app.service.IUserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@GetMapping("/list")
	public String list(Model model) {
		
		model.addAttribute("title", "User list");
		model.addAttribute("list", userService.findAll() );
		
		return "user/user-list";
	}
	@GetMapping("/form")
	public String create(Map<String, Object> model) {
		model.put("title", "New User form");
		model.put("user", new User());
		
		
		return"user/form";
	}
	@PostMapping("/form")
	public String save(@Valid User user, BindingResult result, Model model, RedirectAttributes flash) {
		if(result.hasErrors()) {
			
			model.addAttribute("title", "New User Form");
			return "user/form";
		}
		
		
		userService.save(user);
		flash.addFlashAttribute("success", "User successfully added");
		return"redirect:list";
	}
	
		@GetMapping("/form/{id}")
	public String update(@PathVariable("id") Long id, Map<String, Object> model) {
		User user = null;
		if(id > 0) {
			user = userService.findOne(id);	
		}else {
			return"redirect:/listar";
		}
		model.put("user", user);
		model.put("title", "Edit User");
		
		return"user/form";
	}
	
		@GetMapping("/delete/{id}")
		public String delete(@PathVariable("id")Long id, Model model, RedirectAttributes flash) {
			
			if(id > 0) 
				userService.delete(id);
			flash.addFlashAttribute("warning", "User was successfully removed");
			return "redirect:/user/list";
		}	
}
