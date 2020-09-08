package com.frontpier.dao;

import java.util.List;

import com.frontpier.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer tmpCustomer);

	public Customer getCustomer(int tmpCustomerID);

	public void deletCustomer(int tmpCustomerID);
	
}
