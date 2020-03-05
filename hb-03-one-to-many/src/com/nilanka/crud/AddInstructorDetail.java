package com.nilanka.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nilanka.entity.Course;
import com.nilanka.entity.Instructor;
import com.nilanka.entity.InstructorDetail;

public class AddInstructorDetail {

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
					//Create the Instructor detail object
					InstructorDetail newInstructorDetail = new InstructorDetail("www.youtube.com/vijay","PAYMENTS GW TALK");
					
					
					//Begin  transaction
					session.beginTransaction();	
					
					//get the Instructor
					int tmpInstructorId = 3;
					Instructor tmpInstructor= session.get(Instructor.class, tmpInstructorId);
					
					//associate the object 
					tmpInstructor.setInstructorDetail(newInstructorDetail);
					
							
					
					//save the instructor
					// This will also save the details object
					/*
					 * because cascade type :ALL
					 * plus because of the FK association
					 */
					System.out.println("Saving Instructor - "+tmpInstructor);
					session.save(tmpInstructor);
					
					
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
