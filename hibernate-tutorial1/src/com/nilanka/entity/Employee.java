package com.nilanka.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.nilanka.crud.DateUtils;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "company")
	private String company;
	
	 @Column(name="date_of_birth")
	 @Temporal(TemporalType.DATE)    
	 private Date dateOfBirth;

	public Employee() {

	}
	

	public Employee(String firstName, String lastName, String company, Date dateOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}


	@Override
	public String toString() {
		 return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", company=" + company
	                + ", dateOfBirth=" + DateUtils.formatDate(dateOfBirth) + "]";
	}

	
	
	
	

}
