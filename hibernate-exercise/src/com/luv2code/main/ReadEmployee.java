package com.luv2code.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;



public class ReadEmployee {

	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		// Create session
		Session session = factory.getCurrentSession();
		
		try{
			//NEW CODE FOR  READING DATA
			int tmpEmpID = 5;
			System.out.println("Get Employee Details for EMP ID - "+ tmpEmpID);
			
			//Get a new session
			session = factory.getCurrentSession();
			
			//begin transaction
			session.beginTransaction();
			
			//retrieve the student based on ID(primary key that was generated when we saved the student in the DB)
			Employee tmpEmp = session.get(Employee.class, tmpEmpID);
			System.out.println("GET COMPLETED - "+tmpEmp);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Completed");
		
		}finally{
			factory.close();
		}
	}
}
