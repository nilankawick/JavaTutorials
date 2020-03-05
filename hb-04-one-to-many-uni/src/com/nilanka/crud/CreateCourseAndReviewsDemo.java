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
					Course tmpCourse = new Course("Kung fu for lasen - part II");
					
					/*
					 * The next steps are additional steps, not part of the orignal tutorial 
					 */
					
					//link the course to a instructor
					int theID = 3;
					Instructor tmpInstructor = session.get(Instructor.class,theID);
					System.out.println("Fetched the instructor to be attached to the course");
					System.out.println(tmpInstructor);
					
					//adding the instructor to the course
					tmpInstructor.add(tmpCourse);
					
					/*
					 * END OF ADDITIONAL STEPS
					 */
					
					//add some reviews
					tmpCourse.addReview(new Review("This course is super"));
					tmpCourse.addReview(new Review("needs less information"));
					tmpCourse.addReview(new Review("bad course for absolute beginners"));
					
					//Save the course... and use cascade attribute to save reviews
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
