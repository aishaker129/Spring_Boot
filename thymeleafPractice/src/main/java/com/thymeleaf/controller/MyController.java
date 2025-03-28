package com.thymeleaf.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import ch.qos.logback.core.model.Model;

@Controller
public class MyController {
	
	@RequestMapping(value="/about",method = RequestMethod.GET)
	public String about(Model model) {
		System.out.println("Inside about handler");
		
		model.addAttribute("name","AI Shaker");
		model.addAttribute("currentTime",new Date());
		
		return "about";
		// about.html
	}
	
	@GetMapping("/loop-example")
	public String itarator(Model m) {
		
		// create a list to traverse each item
		
		List<String> names = List.of("AI","Shaker","Mahfuz","Rifat","Ali");
		m.addAttribute("name",names);
		return "iterator";
	}
}
