package com.nilanka.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nilanka.entity.Course;
import com.nilanka.entity.Instructor;
import com.nilanka.entity.InstructorDetail;
import com.nilanka.entity.Review;
import com.nilanka.entity.Student;

public class AddCoursesForStudent {

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
					
					//get the student for which courses will be added
					System.out.println("\nGetting the students to whom which course are to be added");
					int tmpStudentId = 2;
					Student tmpStudent = session.get(Student.class, tmpStudentId);
					//System.out.println(tmpStudent);
	
					
					if(tmpStudent == null)
					{
						System.out.println("\nCreate new student to add courses to");
						tmpStudent = new Student("test1"+tmpStudentId, "test1"+tmpStudentId, "test"+tmpStudentId+"@yahoo.com");
						// Save the the student...
						//session.save(tmpStudent);
						System.out.println("New Student Created with ID: " + tmpStudent.getId());
					}else{
						System.out.println(tmpStudent);
						System.out.println("Existing Courses for the student: "+tmpStudent.getCourses() );
					}
					
					 
					//add or create more courses
					System.out.println("\nGetting the course that is to be added");
					int tmpCourseId = 16;
					Course tmpCourse = session.get(Course.class, tmpCourseId);
					
					if(tmpCourse == null){
						System.out.println("\nCreate new Course");
						tmpCourse = new Course("TEST COURSE - "+tmpCourseId);
						session.save(tmpCourse);
						System.out.println("New Course Created with ID: " + tmpCourse.getId());
					}else{
						System.out.println("Course to be added: " + tmpCourse.getId());
					}
					
					tmpStudent.addCourses(tmpCourse);
				
					//save the courses 
					System.out.println("\nAdding courses to the `student");
					session.save(tmpStudent);
				
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
