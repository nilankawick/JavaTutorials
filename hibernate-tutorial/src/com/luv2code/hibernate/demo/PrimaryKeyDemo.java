package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save java object

			// create 3 student object
			System.out.println("Creating 3 new student object....");
			Student tempStudent1 = new Student("Nil", "Asiri", "naw4ever@gmail.com");
			Student tempStudent2 = new Student("Meth", "Atth", "methsala.a@gmail.com");
			Student tempStudent3 = new Student("An", "Wick", "anoja.wick@gmail.com");

			// begin transaction
			session.beginTransaction();

			// save the object
			System.out.println("Saving the students");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			// commit the object
			session.getTransaction().commit();
			System.out.println("Completed");

		} finally {
			factory.close();
		}

	}

}
