package com.luv2code.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.luv2code.springdemo.mvc.validation.CourseCode;

public class Customer {
	
	private String firstName;
	
	@NotNull(message ="is required")
	@Size(min=2, message="is required")
	private String lastName;
	
	/*
	 * We are using the wrapper class INTEGER instead of "int" to handle strings and empty strings
	 * that can be entered into the system
	 * 
	 */
	@NotNull(message ="is required")
	@Min(value=0, message="Value must be greater than Zero")
	@Max(value=10, message="Value must be less than Ten")
	private Integer freePasses;
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="only 5 chars/digits")
	private String postalCode;
	
	@NotNull
	@CourseCode(value={"CRS","COURSE"}, message="must start with CRS<number> or COURSE<number>")
	private String courseCode;
	
/*
	public Customer() {
		
	}
	*/
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePass) {
		this.freePasses = freePass;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	
	
	

}
