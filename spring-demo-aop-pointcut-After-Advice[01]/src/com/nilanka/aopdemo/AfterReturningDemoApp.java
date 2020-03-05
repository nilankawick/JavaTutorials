package com.nilanka.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nilanka.aopdemo.dao.AccountDAO;
import com.nilanka.aopdemo.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		
		System.out.println("**** AOP After return advice EXAMPLE **** \n");
		System.out.println();
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		
		//get the bean from the spring container
		System.out.println(" *** STEP 1 - Getting the BEANS ***");
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		List<Account> theAccounts = theAccountDAO.findAccounts();
		
		//Display the accounts
		System.out.println("\n *** Getting Accounts ***");
		System.out.println(theAccounts);
		System.out.println("\n");
		
		//close the context
		context.close();
		

	}

}
