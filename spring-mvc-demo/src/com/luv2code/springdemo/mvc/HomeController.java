package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/home")
public class HomeController {

	@RequestMapping("/home")
	public String showPage(){
		return "main-menu";
	}
	
	/*
	 * This is the default page that will load
	 
	@RequestMapping("/")
	public String showIndex(){
		return "Index";
	}
	*/
	
	/**/
	@RequestMapping("/")
	public String showIndex1(){
		return "main-menu";
	}
	
	
}
 