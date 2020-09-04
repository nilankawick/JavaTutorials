package com.luv2code.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebLoginController {
	
	@GetMapping("/enforceLogin")
	public String loginPage() {
		System.out.println("DEBUG --> Requesting user login");
		return "login-page";
	}
	
	
	//for access based access limitations
	@GetMapping("/access-denied")
	public String accessDenied() {
		System.out.println("DEBUG --> access denied");
		return "access-denied";
	}

}
