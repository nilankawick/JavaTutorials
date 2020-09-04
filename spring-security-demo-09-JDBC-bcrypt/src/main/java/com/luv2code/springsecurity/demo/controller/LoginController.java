package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@GetMapping("/enforceLogin")
	public String loginPage() {
		System.out.println("Enforcing login");
		return "fancy-login";
	}
	
	@RequestMapping("/access-denied")
	public String accessDenied() {
		System.out.println("Access Denied");
		return "access-denied";
	}

}
