package com.frontpier.cruddemo.dao;

import java.util.List;

import com.frontpier.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	
	public List<Employee> findAllEmployees();
	
	public Employee findById(int theID);
	
	public void save(Employee emp);
	
	public void deleteByID(int theID);
	
	

}
