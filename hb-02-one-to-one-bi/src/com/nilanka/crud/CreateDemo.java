package com.nilanka.crud;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nilanka.entity.Instructor;
import com.nilanka.entity.InstructorDetail;

public class CreateDemo {

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
					//Create the object
					Instructor newInstructor = new Instructor("nilo","Wick","nilo@gmail.com");
					InstructorDetail newInstructorDetail = new InstructorDetail("www.youtube.com/nilo.wick","sleeping");
					
					//associate the object 
					newInstructor.setInstructorDetail(newInstructorDetail);
					
					//Begin  transaction
					session.beginTransaction();			
					
					//save the instructor
					// This will also save the details object
					/*
					 * because cascade type :ALL
					 * plus because of the FK association
					 */
					System.out.println("Saving Instructor - "+newInstructor);
					session.save(newInstructor);
					
					
					//Commit the object
					session.getTransaction().commit();
					System.out.println("Completed");
					
					
				
				}finally{
					factory.close();
				}

	}

}
