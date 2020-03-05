package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();

		try {

			int studentID = 22;
			
			// Get a new session
			session = factory.getCurrentSession();

			// begin transaction
			session.beginTransaction();

			// retrieve the student based on ID(primary key that was generated
			// when we saved the student in the DB)
			System.out.println("Getting student with -" + studentID);

			Student myStudent = session.get(Student.class, studentID);
			System.out.println("Updating student....");
			myStudent.setFirstName("bubbaaaaa");
			
			// commit transaction

			session.getTransaction().commit();
			
			
			/*
			
			//NEW CODE
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			
			//update email for all records
			System.out.println("Update email for all students");
			session.createQuery("update Student set email='wick@gmail.com'").executeUpdate();
			
			// commit transaction

			session.getTransaction().commit();
			*/
			
			
			System.out.println("Completed");

		} finally {
			factory.close();
		}

	}

}
