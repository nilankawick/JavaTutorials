package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

	
	/*
	 * EXCEPTION HANDLING FOR REST API
	 *  - Add an exception handler using @ExceptionHandler
	 *  - Two ways to handle exceptions 
	 *  1. at each @RestController using @ExceptionHandler
	 *  2. Or at a Global level using @ControllerAdvice and then defining within 
	 *  that @ExceptionHandler
	 *  
	 *  The  code block below shows handling exceptions at a Global level
	 *  via @ControllerAdvice and @ExceptionHandler
	 */
	
	/* Global Exception handling	*/
	
	/*
	 * */
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
	
	
	
	
}
