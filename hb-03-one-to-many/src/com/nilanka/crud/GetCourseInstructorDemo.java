package com.nilanka.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nilanka.entity.Course;
import com.nilanka.entity.Instructor;
import com.nilanka.entity.InstructorDetail;

public class GetCourseInstructorDemo {

	public static void main(String[] args) {
		// Create session factory
				SessionFactory factory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Instructor.class)
											.addAnnotatedClass(InstructorDetail.class)
											.addAnnotatedClass(Course.class)
											.buildSessionFactory();
	
				// Create session
				Session session = factory.getCurrentSession();
				
				try{
					/*
					 * Example of Bi-directional operation on  One-to-Many + Many-to-One
					 */
					
					//Begin  transaction
					session.beginTransaction();	
					
					/*
					 * Scenario 01 - One to Many 
					 * One Instructor has Many Courses
					 */
					
					//get the instructor from DB
					System.out.println("\nStart of Scenarion 01 - O2M\n");
					int theId = 4;
					Instructor tmpInstructor = session.get(Instructor.class, theId); 
					
					System.out.println("\nOne to Many Scenario : Instructor - " + tmpInstructor);
					//get courses for the Instructor
					System.out.println("\nOne to Many Scenario : Courses - " + tmpInstructor.getCourses());
					
					System.out.println("\nEnd of Scenarion 01 - O2M\n");
					
					/*
					 * Scenario 02 - Many to One 
					 * One Instructor has Many Courses
					 */
					System.out.println("\nStart of Scenarion 02 - M20 - Courses to Instructor (Bi-directional)\n");
					int tempCourseID = 10;
					Course tmpCourse = session.get(Course.class, tempCourseID); 
					
					System.out.println("\nBi-Directional Scenario : Course - " + tmpCourse);
					//get courses for the Instructor
					System.out.println("\nBi-Directional Scenario : Course - " + tmpCourse.getInstructor());
					
					System.out.println("\nEnd of Scenarion 02 - O2M\n");
					
					
					//Commit the object
					session.getTransaction().commit();
				
				}finally{
					// add clean up code
					session.close(); 
					factory.close();
				}

	}

}
