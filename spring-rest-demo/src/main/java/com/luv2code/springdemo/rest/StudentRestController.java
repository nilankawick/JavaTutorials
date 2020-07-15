package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	// define @PostConstruct to load data onto students List
	// this only happens once after the been is constructed 
	@PostConstruct
	public void loadData() {
	
        theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Lasen", "Wick"));
		theStudents.add(new Student("Nilanka", "Wick"));
		theStudents.add(new Student("Anoja", "Wick"));
		
	}
	
	
	//define end point for /students
	@GetMapping("/students")
	public List<Student> getStudents(){
	
		return theStudents;
	}
	
	
	/*
	 * End point to retrieve a single student at a time
	 * */
		@GetMapping("/students/{studentID}")
		public Student getStudent(@PathVariable int studentID){
			
			
			/*
			 * For this example we using the ID as array index reference 
			 */
			return theStudents.get(studentID);
		}

	
	
}
