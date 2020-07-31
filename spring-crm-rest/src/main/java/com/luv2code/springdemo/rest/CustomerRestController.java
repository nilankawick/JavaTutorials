package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	//Autowire customer service 
	@Autowired
	private CustomerService tmpCustomerService;
	
	//Add Rest mappings 
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		
		return tmpCustomerService.getCustomers();
	}
	
	@GetMapping("/customers/{customerID}")
	public Customer getCustomer(@PathVariable int customerID) {
		
		
		Customer tmpCustomer = tmpCustomerService.getCustomer(customerID); 
		
		if (tmpCustomer == null) {
			throw new CustomerNotFoundException("Customer ID not Found : "+ customerID);
		}
		
		return tmpCustomer;
	}
	
	// adding a customer via a post request
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer tmpCustomer) {
		
		//in the DAO implementation we use saveorUpdate() on the save method
		// we would have to set the ID to 0 , when we use saveOrUpdate() the following is applicable
		/*
		 * id = 0 or null = insert
		 * id != 0 or isnot null = update 
		 */
		tmpCustomer.setId(0);
		
		tmpCustomerService.saveCustomer(tmpCustomer);
		
		
		
		return tmpCustomer;
	}
	
	
	// adding a customer via a post request
	
		@PutMapping("/customers")
		public Customer updateCustomer(@RequestBody Customer tmpCustomer) {
			
			
			tmpCustomerService.saveCustomer(tmpCustomer);
			
			
			return tmpCustomer;
		}
		
	// delete customer
		
		@DeleteMapping("/customers/{customerID}")
		public String deleteCustomer(@PathVariable int customerID) {
			
			Customer tmpCustomer = tmpCustomerService.getCustomer(customerID);
			
			//throw exception if customer is not found
			if (tmpCustomer == null) {
				throw new CustomerNotFoundException("Customer ID not Found : "+ customerID);
			}
			
			
			tmpCustomerService.deleteCustomer(customerID);
			
			
			return "Deleted Customer ID - "+customerID;
		}
	
	

}
