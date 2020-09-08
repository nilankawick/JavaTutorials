package com.frontpier.service;

import java.util.List;

import com.frontpier.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer tmpCustomer);

	public Customer getCustomer(int tmpCustomerID);

	public void deleteCustomer(int tmpCustomerID);

}
