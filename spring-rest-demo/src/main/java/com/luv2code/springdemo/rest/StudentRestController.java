 package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
			
			
			//check to see the if the list size is available on the students list array
			if ((studentID >= theStudents.size()) || (studentID<0)) {
				
				throw new StudentNotFoundException("Student not found :" + studentID);
				
			}
			
			
			/*
			 * For this example we using the ID as array index reference 
			 */
			return theStudents.get(studentID);
		}
		
	
	
		/*
		 * EXCEPTION HANDLING FOR REST API
		 *  - Add an exception handler using @ExceptionHandler
		 *  - Two ways to handle exceptions 
		 *  1. at each @RestController using @ExceptionHandler
		 *  2. Or at a Global level using @ControllerAdvice and then defining within 
		 *  that @ExceptionHandler
		 *  
		 *  The commented code block below shows handling exceptions at the @RestController level
		 *  via @ExceptionHandler
		 */
		
		/* Local Exception handling	*/
		
		/*
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
			 
		
			//Create a StudentErrorResponse
			StudentErrorResponse tmperror = new StudentErrorResponse();
			
			tmperror.setStatus(HttpStatus.NOT_FOUND.value());
			tmperror.setMessage(exc.getMessage());
			tmperror.setTimeStamp(System.currentTimeMillis());
			
			
			
			
			//return ResponseEntity
			
			
			return new ResponseEntity<>(tmperror, HttpStatus.NOT_FOUND);
			
		}
		
		
		// Add an generic exception handler
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
			
			//Create a StudentErrorResponse
			StudentErrorResponse tmperror = new StudentErrorResponse();
			
			tmperror.setStatus(HttpStatus.BAD_REQUEST.value());
			tmperror.setMessage(exc.getMessage());
			tmperror.setTimeStamp(System.currentTimeMillis());
			
			
			
			
			//return ResponseEntity
			
			
			return new ResponseEntity<>(tmperror, HttpStatus.BAD_REQUEST);

		}
		*/
		
		
}
