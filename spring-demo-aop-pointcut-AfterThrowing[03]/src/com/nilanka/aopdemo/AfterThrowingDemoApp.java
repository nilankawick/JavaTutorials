package com.nilanka.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nilanka.aopdemo.dao.AccountDAO;
import com.nilanka.aopdemo.dao.MembershipDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		
		System.out.println("**** AOP After Throwing Advice EXAMPLE **** \n");
		System.out.println();
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		
		//get the bean from the spring container
		System.out.println(" *** STEP 1 - Getting the BEANS ***");
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		
		//call the method to get accounts
		List<Account> theAccounts = null;
		
		try {
			// add a boolean flag to simulate exception handling
			boolean tripWire = true;
			theAccountDAO.findAccounts(tripWire);	
		}
		catch(Exception exc) {
			System.out.println("\n\nMain Program ... caught exception: " +exc);
		}
		
		
		//Display the accounts
		System.out.println("\n *** MAIN APP POST THROWING : Getting Accounts ***");
		System.out.println(theAccounts);
		System.out.println("\n");
		
		//close the context
		context.close();
		

	}

}
