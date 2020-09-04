package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/enforceLogin")
	public String loginPage() {
		System.out.println("Enforcing login");
		return "fancy-login";
	}

}
