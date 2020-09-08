package com.frontpier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frontpier.dao.CustomerDAO;
import com.frontpier.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject the customer DAO
	@Autowired
	private CustomerDAO customerDAO;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// delegating the getCustomer() call to the DAO implementation
		
		return customerDAO.getCustomers();
	}


	@Override
	@Transactional
	public void saveCustomer(Customer tmpCustomer) {
		// TODO Auto-generated method stub
		
		//delegating the save customer request onto the DAO layer
		customerDAO.saveCustomer(tmpCustomer);
		
	}


	@Override
	@Transactional
	public Customer getCustomer(int tmpCustomerID) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomer(tmpCustomerID);
	}

	

	@Override
	@Transactional
	public void deleteCustomer(int tmpCustomerID) {
		// TODO Auto-generated method stub
		
		customerDAO.deletCustomer(tmpCustomerID);
		
	}
	
	

}
