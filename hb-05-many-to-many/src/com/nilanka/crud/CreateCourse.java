package com.nilanka.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nilanka.entity.Course;
import com.nilanka.entity.Instructor;
import com.nilanka.entity.InstructorDetail;
import com.nilanka.entity.Review;
import com.nilanka.entity.Student;

public class CreateCourse {

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

			// Create a Course
			Course tmpCourse = new Course("How to beat the ODDs");

			// Save the the student... and use cascade attribute to save reviews
			session.save(tmpCourse);
			System.out.println("New Course Created with ID: " + tmpCourse.getId());

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
