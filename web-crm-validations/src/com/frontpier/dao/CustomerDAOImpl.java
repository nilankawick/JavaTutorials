package com.frontpier.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.frontpier.entity.Customer;

@Repository 
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	//not required since @transactional is looked at the service level
	// @Transactional
	public List<Customer> getCustomers() {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Customer> getCustomerQuery = currentSession.createQuery("from Customer order by lastName",
				Customer.class);
		
		//execute db query and get the result
		List<Customer> tmpCustomers = getCustomerQuery.getResultList();
		
		// return the result
		return tmpCustomers;
	}



	@Override
	public void saveCustomer(Customer tmpCustomer) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the customer
		
		//currentSession.save(tmpCustomer);
		
		currentSession.saveOrUpdate(tmpCustomer);
		
		

		
	}



	@Override
	public Customer getCustomer(int tmpCustomerID) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		//retrieve the customer from theDB
		Customer tmpCustomer = currentSession.get(Customer.class,tmpCustomerID);
		
		// return the customer
		return tmpCustomer;
	}



	@Override
	public void deletCustomer(int tmpCustomerID) {
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		
		//querty delete the customer with the ID that is passed in
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerID");
		theQuery.setParameter("customerID", tmpCustomerID);
		
		
		theQuery.executeUpdate();
		
	}

	
	
	
}






