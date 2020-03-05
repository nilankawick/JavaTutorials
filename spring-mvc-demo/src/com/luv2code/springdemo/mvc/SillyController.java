package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SillyController {

	// Need a controller method to show the initial HTML Form
	@RequestMapping("/showForm")	
	public String displayTheForm(){
			return "silly";
		}

	

}
