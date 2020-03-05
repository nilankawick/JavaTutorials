package com.nilanka.springdemo.dao;

import java.util.List;

import com.nilanka.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int tmpId);

	public void deleteCustomer(int tmpId);

	public List<Customer> searchCustomers(String theSearchName);
	

}
