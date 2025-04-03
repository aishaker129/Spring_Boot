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
	
	// Conditional Statement in Thymeleaf
	@GetMapping("/condition")
	public String conditionalHandler(Model m) {
		m.addAttribute("isActive",false);
		m.addAttribute("gender","M");
		List<Integer> list = List.of(1,2,3,4,5,6);
		m.addAttribute("myList",list);
		return "conditional";
	}
	
	// handel for including fragment
	@GetMapping("/services")
	public String servicesHandler(Model m) {
		m.addAttribute("title","Java Spring Boot");
		m.addAttribute("subtitle","Best stack for microservices");
		return "services";
	}
	
	@GetMapping("/newabout")
	public String newAbout() {
		return "aboutNew";
	}
}
