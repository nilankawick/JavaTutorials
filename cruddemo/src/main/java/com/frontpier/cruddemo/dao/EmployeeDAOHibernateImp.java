package com.frontpier.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.frontpier.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImp implements EmployeeDAO {

	//define fields for entity manager
	private EntityManager entityManager;
	
	//setup constructor injection 
	@Autowired
	public EmployeeDAOHibernateImp(EntityManager tmpEntityManager) {
		System.out.println("DEBUG ---> Inside the EmployeeDAOHibernateImp - No Arg Constructor used Constructor Injection - EntityManager ");
		entityManager = tmpEntityManager;
		
	}
	
	
	@Override
	public List<Employee> findAllEmployees() {
		System.out.println("DEBUG ---> Inside the EmployeeDAOHibernateImp - findAllEmployees()");
		//get the hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create the query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		
		//execute the query
		List<Employee> employees = theQuery.getResultList();
		
		
		//return results 
		return employees;
	}


	@Override
	public Employee findById(int theID) {
		
		System.out.println("DEBUG ---> Inside the EmployeeDAOHibernateImp - findById() - parameter passed in : " + theID);
		
		//get the hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//get the employee
		Employee theEmployee = currentSession.get(Employee.class, theID);
				
		//return the employee
		return theEmployee;
	}


	@Override
	public void save(Employee emp) {
		
		System.out.println("DEBUG ---> Inside the EmployeeDAOHibernateImp - save() - parameter passed in : " + emp);
		
		//get the hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//save the employee
		currentSession.saveOrUpdate(emp);
	}


	@Override
	public void deleteByID(int theID) {
		
		System.out.println("DEBUG ---> Inside the EmployeeDAOHibernateImp - deleteByID() - parameter passed in : " + theID);
		
		
		//get the hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//delete object with the primary key
		Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeID");
		theQuery.setParameter("employeeID", theID);
		
		theQuery.executeUpdate();
	}

}
