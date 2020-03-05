package com.nilanka.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nilanka.entity.Course;
import com.nilanka.entity.Instructor;
import com.nilanka.entity.InstructorDetail;
import com.nilanka.entity.Review;
import com.nilanka.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
		// Create session factory
				SessionFactory factory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Instructor.class)
											.addAnnotatedClass(InstructorDetail.class)
											.addAnnotatedClass(Course.class)
											.addAnnotatedClass(Review.class)
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();
	 
				// Create session
				Session session = factory.getCurrentSession();
				
				try{
					
					//Begin  transaction
					session.beginTransaction();	
					
					//Create a Course
					Course tmpCourse = new Course("BABY TV - Lasens Adventures");
					
					//save the course
					System.out.println("\n Creating the course");
					session.save(tmpCourse);
					System.out.println("\nSaved the course:"+tmpCourse);
					
					//create some students
					Student tmpStudent1 = new Student("Lasen", "Wick", "lasen.wick@yahoo.com");
					Student tmpStudent2 = new Student("test1", "test1", "test1@yahoo.com");
					
					//using the convenience method add students 
					tmpCourse.addStudent(tmpStudent1);
					tmpCourse.addStudent(tmpStudent2);
					
					//save the students 
					System.out.println("\nSaving Students....");
					session.save(tmpStudent1);
					session.save(tmpStudent2);
					System.out.println("Students Saved: "+tmpCourse.getStudents());
					
					
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
