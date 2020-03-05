package com.nilanka.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.nilanka.entity.Course;
import com.nilanka.entity.Instructor;
import com.nilanka.entity.InstructorDetail;

public class FetchJoinDemo {

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
					
					//Begin  transaction
					session.beginTransaction();	
					
					/*
					 * Option 2: Using HQL
					 */
					
					//get the instructor from DB
					int theId = 1;
					
					Query<Instructor> query = session.createQuery("select i from Instructor i "
							+"JOIN FETCH i.courses "
							+"where i.id=:theInstructorId",
							Instructor.class);
					
					//Set the theInstructorId parameter
			 		query.setParameter("theInstructorId", theId);
					//Execute  HQL query and get Instructor
					Instructor tmpInstructor = query.getSingleResult();
					
					
					System.out.println("Debug Mode: Instructor - " + tmpInstructor);
					// System.out.println("Debug Mode: Instructor Detail - " + tmpInstructor.getInstructorDetail());
					
					//Commit the object
					session.getTransaction().commit();
					
					//close the session
					session.close();
					
					System.out.println("\nDebug Mode: session closed");
					//get courses for the Instructor
					
					System.out.println("Debug Mode: Accessing Courses after session close - " + tmpInstructor.getCourses());
					System.out.println("Debug Mode: Accessing Instructor Detail after session close- " + tmpInstructor.getInstructorDetail());
					/*
					 *  this above will throw an error since courses are
					 *  a. LAZY loaded
					 *  b. we are trying to get values once the session is closed (refer to session.close() block above
					 *  
					 *  Workaround
					 *  option 1. load courses prior to closing sessions (see EagerLazyDemo.java)
					 *  option 2. querying with HQL... 
					 */
					
					
					System.out.println("Debug Mode: Completed");
					
					
				
				}finally{
					// add clean up code
					session.close(); 
					factory.close();
				}

	}

}
