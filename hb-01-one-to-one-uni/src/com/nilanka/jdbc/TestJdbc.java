package com.nilanka.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		System.out.println("hello");

		String jdbcURL = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String usr="hbstudent";
		String pass="hbstudent";
		
		System.out.println("testing on db usr - " + usr);
		try{
			
			System.out.println("Connecting to DB: "+jdbcURL);
			
			Connection myConn = DriverManager.getConnection(jdbcURL,usr,pass); 
			System.out.println("Connection successful!!!!");	
		
			}catch (Exception exc){
				
				exc.printStackTrace();
			}
	}

}
