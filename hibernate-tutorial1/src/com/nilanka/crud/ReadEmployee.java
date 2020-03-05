package com.nilanka.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nilanka.entity.Employee;

public class ReadEmployee {

	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();
		try{
		
		//READING DATA
		int tempID = 8;
		System.out.println("\nReading data of Employee with the ID - "+ tempID);
		
		//begin transaction
		session.beginTransaction();
		
		Employee myEmp = session.get(Employee.class,tempID);
		
		System.out.println("Information retrieved - "+myEmp);
		
		//commit transaction
		session.getTransaction().commit();
		
		}finally{
			factory.close();
		}

	}

}
