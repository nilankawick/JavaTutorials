package com.nilanka.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nilanka.entity.Course;
import com.nilanka.entity.Instructor;
import com.nilanka.entity.InstructorDetail;

public class CreateCoursesDemo {

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
					
					//get the instructor from DB
					int theId = 3;
					Instructor tmpInstructor = session.get(Instructor.class, theId); 
					
					// create some courses
					Course tmpCourse1 = new Course("JAVA training-1");
					Course tmpCourse2 = new Course("Payment gw development-1");
					
					//add courses to instructor
					tmpInstructor.add(tmpCourse1);
					tmpInstructor.add(tmpCourse2);
					
					//save the courses
					session.save(tmpCourse1);
					session.save(tmpCourse2);
			
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
