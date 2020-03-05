package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

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
			
			System.out.println("\nQuery on students");
			// begin  transaction
			session.beginTransaction();		
			
			//Query the students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//Display the students
			displayStudents(theStudents);
			
			//Query students where last name wick
			System.out.println("\nQuery on students where lastName contains wick");
			theStudents = session.createQuery("from Student s where s.email like '%wick%'").getResultList();
			
			displayStudents(theStudents);
			
			//Query students where last name wick
			System.out.println("\nQuery on students where First Name contains la");
			theStudents = session.createQuery("from Student s where s.firstName like '%la%'").getResultList();
			displayStudents(theStudents);
			
			//commit the object
			session.getTransaction().commit();
			System.out.println("Completed");
			
			
		}finally{
			factory.close();
		}
		
	}

	private static void displayStudents(List<Student> tmpStudents) {
		for (Student tempStudent: tmpStudents){
			System.out.println(tempStudent);
		}
	}

}
