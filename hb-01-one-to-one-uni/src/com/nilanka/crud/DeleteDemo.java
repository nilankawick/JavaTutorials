package com.nilanka.crud;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

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
					
					
					//Query all instructors
					System.out.println("\nQuery all instructors\n");
					List<Instructor> tmpInstructors = session.createQuery("from Instructor").getResultList();
					System.out.println("All instructors");
					displayInstructors(tmpInstructors);
					
					
					//get the instructor by their primary key
					
					int theID = 4;
					System.out.println("\nDelete instructors with ID - "+theID+"\n");
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
						
						
						//Query all instructors after delete
						System.out.println("\nQuery all instructors after delete\n");
						List<Instructor> tmpInstructors1 = session.createQuery("from Instructor").getResultList();
						System.out.println("Remaining instructors");
						displayInstructors(tmpInstructors1);
						
						
						
					}else{
						System.out.println("Instructor not found with ID - "+theID);
					}
					
					
					//Commit the object
					session.getTransaction().commit();
					System.out.println("Completed");
					
					
				
				}finally{
					factory.close();
				}

	}
	
	
	private static void displayInstructors(List<Instructor> instructors) {
		for(Instructor tmpInstructor: instructors){
			System.out.println(tmpInstructor);
		}
	}

}
