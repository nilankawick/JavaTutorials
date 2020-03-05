package com.nilanka.crud;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nilanka.entity.Course;
import com.nilanka.entity.Instructor;
import com.nilanka.entity.InstructorDetail;
import com.nilanka.entity.Review;
import com.nilanka.entity.Student;

public class CreateE2Eflow {

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
				
				try{
					
					//Steps taken
					/*
					 * 1. Create Instructor 
					 * 2. Create Instructor Detail 
					 * 3. Create Course
					 * 4. Link Course Instructor 
					 * 5. Create Course Review
					 * 6. Create Student
					 * 7. Link Student to Course
					 * 8.
					 * 9. Commit 
					 */
					
					//Begin  transaction
					session.beginTransaction();	
					
					// Step:1&2 //
					
					Instructor tmpInst = new Instructor("CHamil","Prabodha","Chamil.P@yahoo.com");
					InstructorDetail tmpInsDetail = new InstructorDetail("www.youtube.com/chamil","Driving");
					
					tmpInst.setInstructorDetail(tmpInsDetail);
					
					
					// End: Step 1&2 //
					
					// Step:3&4 //
					Course tmpCourse = new Course("How to create web services");
					tmpInst.add(tmpCourse);
					// End: Step 3&4 //
					
					// Step:5 //
					tmpCourse.addReview(new Review("This course okay"));
					tmpCourse.addReview(new Review("needs more examples"));
					tmpCourse.addReview(new Review("Too too fast"));
					
					// End: Step 5 //
					
					// Step:6 //
					Student tmpStudent1 = new Student("Nilanka", "Wick", "Nilanka.wick@yahoo.com");
					Student tmpStudent2 = new Student("Diluka", "Talagale", "Diluka.T@yahoo.com");
					
					// End: Step 6 //
					
					// Step:7 //
					
					//using the convenience method add students 
					tmpCourse.addStudent(tmpStudent1);
					tmpCourse.addStudent(tmpStudent2);
					
					// End: Step 7 //
					
					// Step:8 //
					//Saving the object
					
					// with cascading we should be saving instructor-->InstructorDetail
					System.out.println("\n Saving Instructor & Instructor Details via cascade - "+tmpInst);
					session.save(tmpInst);
					
					
					
					//check if we have to save course separately , to save reviews and to save students
					System.out.println("\n Saving Course and course reviews via cascade - "+tmpCourse);
					session.save(tmpCourse);
					
					System.out.println("\n Saving Student & student course via cascade - "+tmpStudent1);
					session.save(tmpStudent1);
					
					System.out.println("\n Saving Student & student course via cascade - "+tmpStudent2);
					session.save(tmpStudent2);
					//
					
					
					// End: Step 8 //
					
					// Step:9 //
					//Commit the object
					session.getTransaction().commit();
					
					System.out.println("Completed");
					// End: Step 9 //
					
					/*
					 * 
					 
					//Create a Course
					Course tmpCourse = new Course("BABY TV - Lasens Adventures");
					
					//save the course
					System.out.println("\n Creating the course");
					session.save(tmpCourse);
					System.out.println("\nSaved the course:"+tmpCourse);
					
					//create some students
					Student tmpStudent1 = new Student("Lasen", "Wick", "lasen.wick@yahoo.com");
					Student tmpStudent2 = new Student("test1", "test1", "test1@yahoo.com");
					
					//using the convenience method add students 
					tmpCourse.addStudent(tmpStudent1);
					tmpCourse.addStudent(tmpStudent2);
					
					//save the students 
					System.out.println("\nSaving Students....");
					session.save(tmpStudent1);
					session.save(tmpStudent2);
					System.out.println("Students Saved: "+tmpCourse.getStudents());
					
					
					//Commit the object
					session.getTransaction().commit();
					
					System.out.println("Completed");
					
					*
					*/
				
				}finally{
					// add clean up code
					session.close(); 
					factory.close();
				}

	}

}
