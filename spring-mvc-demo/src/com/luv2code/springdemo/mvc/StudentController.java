package com.luv2code.springdemo.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Value("#{nationalityOptions}") 
	private Map<String, String> nationalityOptions;
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel){
		
		//Create a new Student Object
		Student theStudent = new Student();
		
		//add Student object to the Model
		/*
		 * We are adding the object theStudent into the model and referring to the same as Name
		 */
		theModel.addAttribute("student", theStudent);
		
		// add the nationality options to the model 
	    theModel.addAttribute("theNationalityOptions", nationalityOptions);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent){
		
		//Log the input data
		System.out.println("***** Start : Log Entry ******");
		System.out.println("theStudent: "+theStudent.getFirstName()+"  "+theStudent.getLastName());
		System.out.println(theStudent.getCountry() + " "+theStudent.getNationality());
		System.out.println(theStudent.getFavouriteLanguage());
		System.out.println(theStudent.getFavouriteCodingLanguage());
		for(String OS:theStudent.getPreferredOS()){
			System.out.println(OS);	
		}
		System.out.println("********Finish : Log Entry *********");
		return "student-confirmation";
		
	}
	
	
	

}
