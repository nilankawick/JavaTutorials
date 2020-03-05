package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student tempStudent =  new Student("willy","Wonka","willy@wonka.com");
			
			// begin  transaction
			session.beginTransaction();			 
			
			//save the object
			System.out.println("Saving the student");
			System.out.println(tempStudent);
			session.save(tempStudent);
		
			//commit the object
			session.getTransaction().commit();
			
			//NEW CODE FOR  READING DATA
			System.out.println("\nStudents ID - "+ tempStudent.getId());
			
			//Get a new session
			session = factory.getCurrentSession();
			
			//begin transaction
			session.beginTransaction();
			
			//retrieve the student based on ID(primary key that was generated when we saved the student in the DB)
			System.out.println("Getting student with -"+tempStudent.getId());
			
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("GET COMPLETED - "+myStudent);
			//commit transaction
			
			session.getTransaction().commit();
			System.out.println("Completed");
			
			
			
			
			
		}finally{
			factory.close();
		}
		
	}

}
