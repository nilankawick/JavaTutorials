package com.frontpier.cruddemo.service;

import java.util.List;

import com.frontpier.cruddemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAllEmployees();
	
	public Employee findById(int theID);
	
	public void save(Employee emp);
	
	public void deleteByID(int theID);

}
