package com.nilanka.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nilanka.entity.Course;
import com.nilanka.entity.Instructor;
import com.nilanka.entity.InstructorDetail;
import com.nilanka.entity.Review;
import com.nilanka.entity.Student;

public class AddCourseReview {

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

			System.out.println("\n **** Adding a reviews to a course ****\n");
			// Begin transaction
			session.beginTransaction();

			// get the Course along with existing information
			int tmpCourseID = 18;
			Course tmpCourse = session.get(Course.class, tmpCourseID);
			System.out.println("\nCourse Retrieved : " + tmpCourse);
			System.out.println("The course Instructor Details :  "+ tmpCourse.getInstructor());
			System.out.println("Course Reviews : " + tmpCourse.getReviews());
			
			
			// add a course review
			tmpCourse.addReview(new Review("This course will be taken down shortly - Admin Notice"));

			//save or update the course 
			session.save(tmpCourse);
			
			// see the updates 
			System.out.println("Course Reviews : " + tmpCourse.getReviews());
			
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
