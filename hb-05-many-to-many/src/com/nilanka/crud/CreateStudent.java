package com.nilanka.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nilanka.entity.Course;
import com.nilanka.entity.Instructor;
import com.nilanka.entity.InstructorDetail;
import com.nilanka.entity.Review;
import com.nilanka.entity.Student;

public class CreateStudent {

	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();

		try {

			// Begin transaction
			session.beginTransaction();

			// Create a student
			Student tmpStudent = new Student("Nilanka", "Wick", "nilanka.wick@yahoo.com");

			// Save the the student... and use cascade attribute to save reviews
			session.save(tmpStudent);
			System.out.println("New Student Created with ID: " + tmpStudent.getId());

			// Commit the object
			session.getTransaction().commit();

			System.out.println("Completed");

		} finally {
			// add clean up code
			session.close();
			factory.close();
		}

	}

}
