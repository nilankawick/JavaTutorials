package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class GetNameController {
	
	//Need a controller method to show the initial HTML Form
	
	@RequestMapping("/showForm")
	public String getNameForm(){
		return "getname-form";
	}
	
	//Need c controller method to process the HTML Form
	@RequestMapping("/processForm")
	public String processForm(){
		return "processname";
	}
	
	//new controller method to read form data + add data to model
	/*
	 * with Spring MVC
	 * the HttpServletRequest allows you to access form data via conroller methods
	 * Model allows u to add data to the model 
	 */
	@RequestMapping("/processFormVersion2")
	public String letsShoutDude(HttpServletRequest request, Model model){
		//Read the data from the HTTP form
		String theName = request.getParameter("studentName");
		
		//Convert data to all CAPS
		theName = theName.toUpperCase();
		
		//Create the message
		String result = "Yo! " + theName;
		
		//add to model
		model.addAttribute("message",result);
		
		return "processname";
	}
	
	/*
	 * Using @RequestParams annotation to directly access form data
	*/ 
	@RequestMapping("/processFormVersion3")
	public String letsShoutDudeVersionTwo(@RequestParam("studentName") String theName, Model model){
		
		
		//Convert data to all CAPS
		theName = theName.toUpperCase();
		
		//Create the message
		String result = "Hey My friend " + theName;
		
		//add to model
		model.addAttribute("message",result);
		
		return "processname";
	}
	
	
}
