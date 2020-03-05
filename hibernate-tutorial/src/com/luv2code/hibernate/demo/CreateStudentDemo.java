package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		 
		
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try{
			//use the session object to save java object
			
			// create student object
			System.out.println("Creating a new student object....");
			Student tempStudent =  new Student("Lasen","Wick","lasen@yahoo.co.uk");
			
			// begin  transaction
			session.beginTransaction();			
			
			//save the object
			System.out.println("Saving the student");
			session.save(tempStudent);
		
			//commit the object
			session.getTransaction().commit();
			System.out.println("Completed");
			
			
		}finally{
			factory.close();
		}
		
	}

}
