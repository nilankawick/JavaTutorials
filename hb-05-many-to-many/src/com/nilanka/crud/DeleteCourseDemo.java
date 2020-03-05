package com.nilanka.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nilanka.entity.Course;
import com.nilanka.entity.Instructor;
import com.nilanka.entity.InstructorDetail;
import com.nilanka.entity.Review;
import com.nilanka.entity.Student;

public class DeleteCourseDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			System.out.println("\n **** Deleting a course ****\n");
			// start a transaction
			session.beginTransaction();
				
			//get the course
			int tmpCourseID = 18;
			Course tmpCourse =session.get(Course.class, tmpCourseID);
			System.out.println("Deleting Course - "+tmpCourse);
			System.out.println("The course Instructor Details :  "+ tmpCourse.getInstructor());
			System.out.println("Course Reviews : " + tmpCourse.getReviews());
			
			//delete the course
			session.delete(tmpCourse);
						
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}





