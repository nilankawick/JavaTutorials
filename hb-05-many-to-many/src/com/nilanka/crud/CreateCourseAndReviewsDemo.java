package com.nilanka.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nilanka.entity.Course;
import com.nilanka.entity.Instructor;
import com.nilanka.entity.InstructorDetail;
import com.nilanka.entity.Review;

public class CreateCourseAndReviewsDemo {

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
					
					//Create a Course
					Course tmpCourse = new Course("BABY TV - Lasens Adventures");
					
					//add some reviews
					tmpCourse.addReview(new Review("Good course for Babies"));
					tmpCourse.addReview(new Review("Lasen is very good"));
					tmpCourse.addReview(new Review("Learnt a lot"));
					
					//Save the course... and use cascade attribute to save reviews
					System.out.println("Saving the course");
					System.out.println(tmpCourse);
					System.out.println(tmpCourse.getReviews());
					session.save(tmpCourse);
					
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
