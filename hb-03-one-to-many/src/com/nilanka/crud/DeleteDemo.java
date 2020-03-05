package com.nilanka.crud;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nilanka.entity.Instructor;
import com.nilanka.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		// Create session factory
				SessionFactory factory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Instructor.class)
											.addAnnotatedClass(InstructorDetail.class)
											.buildSessionFactory();
	
				// Create session
				Session session = factory.getCurrentSession();
				
				try{
					
					
					//Begin  transaction
					session.beginTransaction();			
					
					//get the instructor by their primary key
					int theID = 1;
					Instructor tmpInstructor = session.get(Instructor.class, theID);
					
					System.out.println("Found Instructor - "+ tmpInstructor);
					// delete the Instructor
					if (tmpInstructor != null){
						System.out.println("Deleting - "+tmpInstructor);
						
						/*
						 * this will also delete the Instructor detail record
						 * due to FK annotation + Cascade ALL setup
						 */
						session.delete(tmpInstructor);
					}
					
					
					//Commit the object
					session.getTransaction().commit();
					System.out.println("Completed");
					
					
				
				}finally{
					factory.close();
				}

	}

}
