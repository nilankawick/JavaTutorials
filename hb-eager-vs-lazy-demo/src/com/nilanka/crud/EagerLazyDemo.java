package com.nilanka.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nilanka.entity.Course;
import com.nilanka.entity.Instructor;
import com.nilanka.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();

		try {

			// Begin transaction
			session.beginTransaction();

			// get the instructor from DB
			int theId = 1;
			Instructor tmpInstructor = session.get(Instructor.class, theId);

			
			System.out.println("\nDebug Mode: Instructor - " + tmpInstructor);
			System.out.println("\n Debug Mode: Get Instructor detail - " + tmpInstructor.getInstructorDetail());
			
			/*
			 * scenario 01 - testing lazing loading prior to closing the session and this is
			 * the way to resolve lazy loading issue
			 */
			System.out.println("\nDebug Mode: Courses - " + tmpInstructor.getCourses());

			// Commit the object
			session.getTransaction().commit();

			// close the session
			session.close();
			System.out.println("\nDebug Mode: session closed");
			

			/*
			 * scenario 02. - testing lazy loading after closing the session if we try to
			 * access a lazy loaded element after the session is closed there will be an
			 * error
			 */

			// get the instructor details
			//System.out.println("\n Debug Mode: Get Instructor detail - " + tmpInstructor.getInstructorDetail());
			
			// get courses for the Instructor
			// System.out.println("Debug Mode: Accessing Courses after session close - " +
			// tmpInstructor.getCourses());

			/*
			 * this above will throw an error since courses are a. LAZY loaded b. we are
			 * trying to get values once the session is closed (refer to session.close()
			 * block above
			 * 
			 * Workaround option 1. load courses prior to closing sessions option 2.
			 * querying with HQL... refer to FetchJoinDemo
			 */

			System.out.println("Debug Mode: Completed");

		} finally {
			// add clean up code
			session.close();
			factory.close();
		}

	}

}
