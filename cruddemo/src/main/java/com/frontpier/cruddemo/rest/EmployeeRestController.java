package com.frontpier.cruddemo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frontpier.cruddemo.dao.EmployeeDAO;
import com.frontpier.cruddemo.entity.Employee;
import com.frontpier.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	//quick and dirty ; inject DAO without the service layer
	
	/*
	 
	private EmployeeDAO employeeDAO;
	
	//using constructor injection to autowire
	public EmployeeRestController(EmployeeDAO tmpEmpDAO) {
		System.out.println("DEBUG ---> Inside the EmployeeRestController - Constructor Injection of the EmployeeDAO");
		employeeDAO = tmpEmpDAO;
	}
	
	* 
	 */
	
	private EmployeeService empService;
	
	//using constructor injection to autowire
		public EmployeeRestController(EmployeeService tmpEmpService) {
			System.out.println("DEBUG ---> Inside the EmployeeRestController - Constructor Injection of the EmployeeService");
			empService = tmpEmpService;
		}
	
	//expose "/employees" to return the list of employees
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		System.out.println("DEBUG ---> Inside the EmployeeRestController - findAll() - /api/employees");
		
		// when using the DAO directly
		//return employeeDAO.findAllEmployees();
		return empService.findAllEmployees();
		
	}
	
	
	
	// find an employee by ID
	@GetMapping("/employees/{employeeID}")
	public Employee getEmployeeByID(@PathVariable("employeeID") int empID) {
		System.out.println("DEBUG ---> Inside the EmployeeRestController - getEmployeeByID() - /employees/{employeeID} ");
		Employee theEmp = empService.findById(empID);
		
		if (theEmp ==null) {
			throw new RuntimeException("Employee ID is not found "+ empID);
		}
		
		return theEmp;
	}
	
	
	// post mapping to create a new employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee tmpEmp) {
		
		System.out.println("DEBUG ---> Inside the EmployeeRestController - addEmployee() - /employees/ - Emp details - "+tmpEmp);
		
		//since we are using saveOrUpdate, to ensure that we are executing an insert 
		// we are going to manually set the ID = 0
		
		tmpEmp.setId(0);
		
		empService.save(tmpEmp);
		
		return tmpEmp;
	}
	
	
	//Update an Employee information using a PUT
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmp) {
		
		System.out.println("DEBUG ---> Inside the EmployeeRestController - updateEmployee() - /employees/ - Emp details - "+theEmp);
		
		empService.save(theEmp);
		
		return theEmp;
	}
	
	//delete an Employee using DELETE
	@DeleteMapping("/employees/{employeeID}")
	public String deleteEmployee(@PathVariable("employeeID") int tmpID) {
		
		System.out.println("DEBUG ---> Inside the EmployeeRestController - deleteEmployee() - /employees/ - Emp ID - "+tmpID);

		
		Employee tmpEmployee = empService.findById(tmpID);
		
		if(tmpEmployee == null) {
			throw new RuntimeException("Employee ID is not found "+ tmpID);
		}
		
		empService.deleteByID(tmpID);
		
		return "Deleted employee with ID - "+tmpID;

		
		
	}
	

}
