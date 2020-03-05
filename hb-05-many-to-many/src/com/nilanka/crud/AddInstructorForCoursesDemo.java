package com.nilanka.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nilanka.entity.Course;
import com.nilanka.entity.Instructor;
import com.nilanka.entity.InstructorDetail;
import com.nilanka.entity.Review;
import com.nilanka.entity.Student;

public class AddInstructorForCoursesDemo {

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
			
			// start a transaction
			session.beginTransaction();
				
			// get the Course from database
			int tmpCourseID = 21;
			Course tempCourse = session.get(Course.class, tmpCourseID);
			
			System.out.println("\nLoaded Course: " + tempCourse);
			System.out.println("Course Instructor: " + tempCourse.getInstructor());
			
			// get instructor for course
			
			int tmpInsID = 13;
			Instructor tmpInstructor = session.get(Instructor.class, tmpInsID);
			
			System.out.println("\nLoaded Instructor: " + tmpInstructor);
			System.out.println("Course Instructor: " + tmpInstructor.getInstructorDetail());
			
			
			// add instructor to course 
			tempCourse.setInstructor(tmpInstructor);
			session.save(tempCourse);
			
			System.out.println("\nCourse Instructor: " + tempCourse.getInstructor());
			
			/*
			*
			*/			
			
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





