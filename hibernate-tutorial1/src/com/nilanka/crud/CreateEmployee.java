package com.nilanka.crud;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nilanka.entity.Employee;

public class CreateEmployee {

	public static void main(String[] args) {
		// Create session factory
				SessionFactory factory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Employee.class)
											.buildSessionFactory();
	
				// Create session
				Session session = factory.getCurrentSession();
				
				try{
					//use the session object to save java object
					
					 String theDateOfBirthStr = "31/03/1982";
			         Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
					
					
					// create employee object
					System.out.println("Creating a new employee object....");
					Employee tempEmp =  new Employee("Kasun","Rane","eCode",theDateOfBirth);
					
					// begin  transaction
					session.beginTransaction();			
					
					//save the object
					System.out.println("Saving the employee");
					session.save(tempEmp);
				
					//commit the object
					session.getTransaction().commit();
					System.out.println("Completed");
					
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					factory.close();
				}

	}

}
