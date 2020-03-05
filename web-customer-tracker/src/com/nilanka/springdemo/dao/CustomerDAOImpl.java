package com.nilanka.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nilanka.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject the session factory so that the DAO can call the DB
	@Autowired
	private SessionFactory  sessionFactory;
	
	@Override
	//@Transactional
	public List<Customer> getCustomers() {
		
		//get the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		//create the query... but sort by last name
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		//execute the query
		List<Customer> customers = theQuery.getResultList();
		
		//return the list of customers
		return customers;
			
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		//get the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save or update the customer
		/*
		 * save will be used if the id field is empty
		 * and update will be used if the ID field is not empty
		 */
		 currentSession.saveOrUpdate(theCustomer);
		 
		
		
	}

	@Override
	public Customer getCustomer(int tmpId) {
				//get the hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				//retrieve and read from the DB using the primary Key
				Customer tmpCustomer = currentSession.get(Customer.class,tmpId);
				
				//return the customers
				return tmpCustomer;
	}

	@Override
	public void deleteCustomer(int tmpId) {
		// get the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete the customer object with primary key that is passed in
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", tmpId);
		
		theQuery.executeUpdate();
		
		
		
	}

	@Override
    public List<Customer> searchCustomers(String theSearchName) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query theQuery = null;
        
        //
        // only search by name if theSearchName is not empty
        //
        if (theSearchName != null && theSearchName.trim().length() > 0) {

            // search for firstName or lastName ... case insensitive
            theQuery =currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

        }
        else {
            // theSearchName is empty ... so just get all customers
            theQuery =currentSession.createQuery("from Customer", Customer.class);            
        }
        
        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();
                
        // return the results        
        return customers;
        
    }

}
