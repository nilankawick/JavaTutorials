package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
	
	@GetMapping("/")
	public String showHome() {
		System.out.println("I am in - Basic Security");
		
		return "home";
	}

	@RequestMapping("/leaders")
	public String showLeaders(){
		System.out.println("Accessing Managers only Link");
		return "leaders";
		
	}
	
	@RequestMapping("/admin")
	public String showAdmin() {
		System.out.println("Accessing Admin only Link");
		return "admin";
	}
	
}
