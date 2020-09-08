package com.frontpier.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.frontpier.dao.CustomerDAO;
import com.frontpier.entity.Customer;
import com.frontpier.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//injecting the DAO into this controller, 
	/*
	 * this allows the customer controller to get access to the DB and associated data retrieval methods 
	 * please note that this is not required if we are using a service layer.
	 * For this exampple we are using a service layer, hence this is commented out
	 */
	/*
	@Autowired
	private CustomerDAO customerDAO;
	*/
	
	
	//injecting the customerService
	@Autowired
	private CustomerService customerService;
	
	
	
	

	//@RequestMapping("/list")
	//@PostMapping("/list")
	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		
		//get the customers from the DAO
		/*
		 * This is not required if we are using a service layer
		 * and in this example we are using the CustomerService layer to manage DAO interactions
		 */
		//List<Customer> tmpCustomer = customerDAO.getCustomers();
		
		List<Customer> tmpCustomer = customerService.getCustomers();
		
		//add the customer to the model
		theModel.addAttribute("customers", tmpCustomer);
		
		return "list-customers";
	}
	
	@GetMapping("/addNewCustomer")
	public String addNewCustomer(Model theModel) {
		
		//create customer object that is to be bound to the form data 
		Customer tmpCustomer = new Customer();
		
		theModel.addAttribute("customer", tmpCustomer);
		return "new-customer-form";
	}
	
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer tmpCustomer,
			BindingResult tmpBindingResult){
		
		System.out.println("\nDEBUG ===> Customer information passed in : "+ tmpCustomer);
		System.out.println("DEBUG ===> Validation status : "+tmpBindingResult);
		System.out.println("***\n");
		
		if (tmpBindingResult.hasErrors()) {
			return "new-customer-form";
		}else {
			//saving the customer using our service
			
			customerService.saveCustomer(tmpCustomer);
			
			return "redirect:/customer/list";	
		}
		
		
		
	}
	
	@GetMapping("/updateCustomer")
	public String updateCustomerInformation(@RequestParam("customerId") int tmpCustomerID,
			Model tmpModel) {
		
		//get the customer from the database through the service
		Customer tmpCustomer = customerService.getCustomer(tmpCustomerID);
		
		
		//set the customer as a model attribute
		tmpModel.addAttribute("customer",tmpCustomer);
		
		return "new-customer-form";
	}
	
	@RequestMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int tmpCustomerID, Model tmpModel) {
		
		//Delegating customer deletion to the service 
		customerService.deleteCustomer(tmpCustomerID);
		
		return "redirect:/customer/list";
	}
	
	
	
}
