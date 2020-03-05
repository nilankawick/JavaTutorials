package com.nilanka.crud;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nilanka.entity.Instructor;
import com.nilanka.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

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
					
					//get the instructor detail object
					int theID = 5;
					InstructorDetail tmpInstructorDetail = session.get(InstructorDetail.class,theID);
					
					//print the instructor detail
					System.out.println("Instructor Detail - " + tmpInstructorDetail);
					
					//print the associated instructor
					System.out.println("Parent instructor - "+tmpInstructorDetail.getInstructor());
					
					/*
					 * remove the associated object reference
					 * Remove the bidirectional link 
					 */
					tmpInstructorDetail.getInstructor().setInstructorDetail(null);
					
					
					//Lets delete the instructor detail
					System.out.println(" \n Deleting instructor detail and associated instructor "+tmpInstructorDetail);
					session.delete(tmpInstructorDetail);
					
					
					//Commit the object
					session.getTransaction().commit();
					System.out.println("Completed");
				
				}
				catch(Exception exc){
					exc.printStackTrace();
				}finally{
					//handle the connection leak issue
					session.close();
					factory.close();
				}

	}

}
