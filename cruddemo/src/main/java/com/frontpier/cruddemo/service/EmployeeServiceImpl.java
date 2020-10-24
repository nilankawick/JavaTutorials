package com.frontpier.cruddemo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frontpier.cruddemo.dao.EmployeeDAO;
import com.frontpier.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO empDAO;
	
	public EmployeeServiceImpl(EmployeeDAO tmpEmpDAO) {
		System.out.println("DEBUG ---> Inside the EmployeeServiceImpl - No Arg Constructor used Constructor Injection - EmployeeDAO ");
		empDAO = tmpEmpDAO;
	}

	@Override
	@Transactional
	public List<Employee> findAllEmployees() {
		
		System.out.println("DEBUG ---> Inside the EmployeeServiceImpl - findAllEmployees()");
		return empDAO.findAllEmployees();
	}

	@Override
	@Transactional
	public Employee findById(int theID) {
		System.out.println("DEBUG ---> Inside the EmployeeServiceImpl - findById()- ID :  "+theID);
		return empDAO.findById(theID);
	}

	@Override
	@Transactional
	public void save(Employee emp) {
		System.out.println("DEBUG ---> Inside the EmployeeServiceImpl - save()- Employee :  "+emp);
		empDAO.save(emp);
	}

	@Override
	@Transactional
	public void deleteByID(int theID) {
		System.out.println("DEBUG ---> Inside the EmployeeServiceImpl - deleteByID()- ID :  "+theID);
		empDAO.deleteByID(theID);
	}

}
