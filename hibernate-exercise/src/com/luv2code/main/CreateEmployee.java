package com.luv2code.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;


public class CreateEmployee {

	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		// Create session
		Session session = factory.getCurrentSession();
		
		try{
			//use the session object to save java object
			
			// create employer object
			System.out.println("Creating new Employee object....");
			Employee tmpEmp = new Employee("Wikum","Wijey","Asette");

			// begin  transaction
			session.beginTransaction();	
			
			//save the object
			System.out.println("Saving the Employee");
			session.save(tmpEmp);
			
			//commit the object
			session.getTransaction().commit();
			System.out.println(tmpEmp);
			System.out.println("Completed");
		
		}finally{
			factory.close();
		}
	}
}
