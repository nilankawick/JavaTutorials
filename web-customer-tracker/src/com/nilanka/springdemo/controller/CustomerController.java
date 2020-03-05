package com.nilanka.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nilanka.springdemo.entity.Customer;
import com.nilanka.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	/*
	 * this is now going to be handled by the service layer 
	 * 
	//inject the DAO to the controller
	@Autowired
	private CustomerDAO customerDAO;
	*/
	
	/*
	 * Inject the customer service
	 * 
	 */
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/list")
	public String listCustomers(Model theModel){
		
		// get the customers from service
		List<Customer> theCustomers = customerService.getCustomers();
		
		//Add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customer";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String addCustomer(Model theModel){
		
		//create model attribute to bind form data
		
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer",theCustomer); 
		
		return "add-customer";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
		
		//save the customer using the service
		customerService.saveCustomer(theCustomer);
		
		
		return "redirect:/customer/list";
	}
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int tmpId,Model theModel){
		System.out.println("Update");
		//get the customer from the service
		Customer tmpCustomer = this.customerService.getCustomer(tmpId);
		
		//add the customer to the model as an attribute
		theModel.addAttribute("customer",tmpCustomer);
		
		//send to the update form
			//return "customer-update-form"; 
			//return "redirect:/customer/list";
		    
		return "add-customer";
		
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int tmpId){
		
		//delete the customer
		
		this.customerService.deleteCustomer(tmpId);
		
		return "redirect:/customer/list";
		
	}
	
	@PostMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {

        // search customers from the service
        List<Customer> theCustomers = this.customerService.searchCustomers(theSearchName);
                
        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customer";        
    }
}
