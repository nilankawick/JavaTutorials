package com.luv2code.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class DeleteEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				// Create session factory
						SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
				// Create session
				Session session = factory.getCurrentSession();
				
		try {
			int empID = 4;
			
			
			// Get a new session
			session = factory.getCurrentSession();

			// begin transaction
			session.beginTransaction();
			
			// retrieve the student based on ID(primary key that was generated
			// when we saved the student in the DB)
			System.out.println("Getting Employee with -" + empID);

			Employee myEmp = session.get(Employee.class, empID);
			System.out.println("deleting Employee - " + myEmp);
			
						/*
						//delete the student
						System.out.println("deleting employee - " + myEmp);
						session.delete(myEmp);
						*/
						
						/*
						//ALTERNATE APPROACH
						*/
			
						System.out.println("\n Deleting the alternate way");
						session.createQuery("delete from Employee where id="+empID).executeUpdate();
						
						// commit transaction
			 			
			
						session.getTransaction().commit();
						System.out.println("Completed");

						
				

	}finally {
		factory.close();
	}

	}
}
