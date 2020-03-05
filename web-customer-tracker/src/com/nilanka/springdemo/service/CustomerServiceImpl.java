package com.nilanka.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nilanka.springdemo.dao.CustomerDAO;
import com.nilanka.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	//need to auto inject DAO
	@Autowired 
	private CustomerDAO customerDAO;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return this.customerDAO.getCustomers();
	}


	@Override
	@Transactional 
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method 
		this.customerDAO.saveCustomer(theCustomer);
		
	}


	@Override
	@Transactional 
	public Customer getCustomer(int tmpId) {
		// TODO Auto-generated method stub
		return this.customerDAO.getCustomer(tmpId);
	}


	@Override
	@Transactional 
	public void deleteCustomer(int tmpId) {
		this.customerDAO.deleteCustomer(tmpId);
		
	}


	@Override
	@Transactional 
	public List<Customer> searchCustomers(String theSearchName) {
		
		 return customerDAO.searchCustomers(theSearchName);
		
	}

}
