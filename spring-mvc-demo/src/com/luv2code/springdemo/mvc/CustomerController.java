package com.luv2code.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//add an initBinder to trim input Strings
	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	

	@RequestMapping("/showForm")
	public String showForm(Model theModel){
		
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
		
	}
	
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer customer,BindingResult theBindingResult){
		System.out.println("***** Start : Log Entry ******");
		
		if(theBindingResult.hasErrors()){
			System.out.println("First Name: |"+customer.getFirstName());
			System.out.println("Last Name: |"+customer.getLastName());
			System.out.println("Free passses: |"+customer.getFreePasses());
			System.out.println("Postal code: |"+customer.getPostalCode());
			System.out.println("Course: |"+customer.getCourseCode());
			System.out.println("Validation Failure");
			System.out.println("Error:");
			System.out.println(theBindingResult.getErrorCount());
			System.out.println(theBindingResult.getObjectName());
			System.out.println(theBindingResult.getFieldError());
			System.out.println(theBindingResult);
			System.out.println("********Finish : Log Entry *********");
			return "customer-form";
		
		}else{
			System.out.println("Validation success");
			System.out.println("First Name: |"+customer.getFirstName());
			System.out.println("Last Name: |"+customer.getLastName());
			System.out.println("Last Name: |"+customer.getFreePasses());
			System.out.println("Last Name: |"+customer.getPostalCode());
			System.out.println("Course: |"+customer.getCourseCode());
			System.out.println("********Finish : Log Entry *********");
			return "customer-confirmation";
			
		}
	}
}
