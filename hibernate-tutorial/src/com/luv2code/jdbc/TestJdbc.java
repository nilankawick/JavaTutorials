package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;



public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("hello");
		String jdbcURL = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String usr="hbstudent";
		String pass="hbstudent";
		
		try{
		
		System.out.println("Connecting to DB: "+jdbcURL);
		
		Connection myConn = DriverManager.getConnection(jdbcURL,usr,pass); 
		System.out.println("Connection successful!!!!");	
	
		}catch (Exception exc){
			
			exc.printStackTrace();
		}
	}

}
