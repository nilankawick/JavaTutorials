package com.nilanka.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.nilanka.entity.Employee;

public class QueryEmployee {

	public static void main(String[] args) {
		// Create session factory
				SessionFactory factory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Employee.class)
											.buildSessionFactory();

				// Create session
				Session session = factory.getCurrentSession();
				
				try{

					System.out.println("\nQuery on Employees");
					// begin  transaction
					session.beginTransaction();	
					
					//Query query = session.createQuery("from Employee");
					List<Employee> employees = session.createQuery("from Employee").getResultList();
					
					displayEmployees(employees);
					
					System.out.println("\nOnly query employees with last name like 'wick'");
					employees = session.createQuery("from Employee e where e.company like '%usa'").getResultList();
					
					displayEmployees(employees);
					
					//commit the object
					session.getTransaction().commit();
					System.out.println("Completed");
					
					
				}finally{
					factory.close();
				}

	}

	private static void displayEmployees(List<Employee> employees) {
		for(Employee tmpEmp: employees){
			System.out.println(tmpEmp);
		}
	}

}
