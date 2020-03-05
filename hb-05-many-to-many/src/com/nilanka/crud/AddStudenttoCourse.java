package com.nilanka.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nilanka.entity.Course;
import com.nilanka.entity.Instructor;
import com.nilanka.entity.InstructorDetail;
import com.nilanka.entity.Review;
import com.nilanka.entity.Student;

public class AddStudenttoCourse {

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

		try {

			// Begin transaction
			session.beginTransaction();

			//get the course
			System.out.println("Getting the course to which students are to be added");
			int tmpCourseId = 11;
			Course tmpCourse = session.get(Course.class, tmpCourseId);
			
			//print the course
			System.out.println(tmpCourse);

			//getting the student that requires to be added to a course
			System.out.println("Getting the student that is to be added");
			int tmpStudentId = 1;
			Student tmpStudent = session.get(Student.class, tmpStudentId);
			System.out.println(tmpStudent);
			
			//adding the student to the course
			tmpCourse.addStudent(tmpStudent);
			session.save(tmpCourse);
			

			// Commit the object
			session.getTransaction().commit();

			System.out.println("Completed");

		} finally {
			// add clean up code
			session.close();
			factory.close();
		}

	}

}
