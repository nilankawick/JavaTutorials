package com.nilanka.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nilanka.entity.Course;
import com.nilanka.entity.Instructor;
import com.nilanka.entity.InstructorDetail;
import com.nilanka.entity.Review;

public class CreateInstructorAndCourseAndReviewsDemo2 {

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
					
					//Step 1. Create a Instructor & Instructor detail
					Instructor tmpInstructor = new Instructor("Chamil","Prabodha","chamil.p@syscolabs.com");
					InstructorDetail tmpInsDetail = new InstructorDetail("www.youtube.com/chamil.p","Coding");
					
					//Step 2. associate the Instructor object with Instructor detail
					tmpInstructor.setInstructorDetail(tmpInsDetail);
					
					//Step 3. Create a Course
					Course tmpCourse = new Course("Java for nilanka");
					
					//Step 4. add the course for Instructor
					tmpInstructor.add(tmpCourse);
					
					//Step 5. add some reviews for course
					tmpCourse.addReview(new Review("This course brillian"));
					tmpCourse.addReview(new Review("needs more information"));
					tmpCourse.addReview(new Review("Too fast"));
					
					
					//Step 6. Save the Instructor & instructor details..
					// instructor detail saving is handled viA CASCADE
					System.out.println("Saving Instructor - "+tmpInstructor);
					session.save(tmpInstructor);
					
					//Step 7. Save the course... and use cascade attribute to save reviews
					System.out.println("Saving the course\n");
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
