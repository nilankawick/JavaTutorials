package com.luv2code.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class GetEmpForCompany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create session factory
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Employee.class)
						.buildSessionFactory();
		// Create session
		Session session = factory.getCurrentSession();
				
		try {
			//use the session object to save java object
			System.out.println("\nQuery on Employees that belong to a certain company\n");
			
			// begin  transaction
			session.beginTransaction();
			
			//Example 1. Query all employees
			List<Employee> tmpEmployees = session.createQuery("from Employee").getResultList();
			
			showEmployees(tmpEmployees);
			
			//Example 2. Query with a where clause
			System.out.println("\nQuery on Employees that belongs to a certain company");
			tmpEmployees = session.createQuery("from Employee e where e.comp_name like '%ikman%'").getResultList();
			showEmployees(tmpEmployees);
			
			//commit the object
			session.getTransaction().commit();
			System.out.println("Completed");
			
		}finally{
			factory.close();
		}

	}

	private static void showEmployees(List<Employee> tmpEmployees) {
		for(Employee tmpEmp: tmpEmployees) {
			System.out.println(tmpEmp);
		}
	}

}
