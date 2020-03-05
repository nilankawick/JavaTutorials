package com.nilanka.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nilanka.entity.Course;
import com.nilanka.entity.Instructor;
import com.nilanka.entity.InstructorDetail;
import com.nilanka.entity.Review;

public class GetCourseAndReviewsDemo {

	public static void main(String[] args) {
		// Create session factory
				SessionFactory factory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Instructor.class)
											.addAnnotatedClass(InstructorDetail.class)
											.addAnnotatedClass(Course.class)
											.addAnnotatedClass(Review.class)
											.buildSessionFactory();
	
				// Create session
				Session session = factory.getCurrentSession();
				
				try{
					
					//Begin  transaction
					session.beginTransaction();	
					
					//get the course
					int tmpCourseId = 13;
					Course tmpCourse = session.get(Course.class, tmpCourseId);
					
					//print the course
					System.out.println("\nPrinting the Course ****");
					System.out.println(tmpCourse);
					//print the course reviews
					System.out.println("\nPrinting the Course Reviews ****");
					System.out.println(tmpCourse.getReviews());
					
					
					//Commit the object
					session.getTransaction().commit();
					
					System.out.println("Completed");
					
					
				
				}finally{
					// add clean up code
					session.close(); 
					factory.close();
				}

	}

}
