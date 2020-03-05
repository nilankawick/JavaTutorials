package com.nilanka.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nilanka.entity.Course;
import com.nilanka.entity.Instructor;
import com.nilanka.entity.InstructorDetail;

public class DeleteInstructorDemo {

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
					
					//get the Instructor
					int tmpInstructorId = 2;
					Instructor tmpInstructor= session.get(Instructor.class, tmpInstructorId);
					
					System.out.println("Delete Instructor - " +tmpInstructor);
					System.out.println("Instructor Detail -"+tmpInstructor.getInstructorDetail());
					//delete the Instructor
					session.delete(tmpInstructor);
					
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
