package com.nilanka.springdemo.service;

import java.util.List;

import com.nilanka.springdemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers(); 

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int tmpId);
 
	public void deleteCustomer(int tmpId);

	public List<Customer> searchCustomers(String theSearchName);

	

}
