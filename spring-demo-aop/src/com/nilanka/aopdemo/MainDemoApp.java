package com.nilanka.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nilanka.aopdemo.dao.AccountDAO;
import com.nilanka.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		
		System.out.println("AOP Example/n");
		System.out.println();
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		
		//get the bean from the spring container
		System.out.println("Getting the BEANS");
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		//get the membership bean from the spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO",MembershipDAO.class);
		
		// SCENARIO A - simple execution sample of before advice
		
		//A-1. calling the addaccount of the AccountDAO
		theAccountDAO.addAccount();
		
		//A-2. calling the addaccount of the membershipDAO
		//theMembershipDAO.addAccount();
		theMembershipDAO.addSillyAccount();
		theMembershipDAO.goToSleep();
		
		//call the business method
		System.out.println("Example of pointcut exp on methods with parameters \n");
		Account newAccount = new Account();
		boolean vipFlag = true;
		
		
		theAccountDAO.addAccount(newAccount,vipFlag); 
		theAccountDAO.doWork();
		
		
		// call the account getter and setter methods  for account name and service name
		theAccountDAO.setAccountName("Nilanka");
		theAccountDAO.setServiceName("GetDead");
		
		/*
		String tmpAccountName = theAccountDAO.getAccountName();
		String tmpServiceName = theAccountDAO.getServiceName();
		*/
		
		
		
		
		
		
		//second run
		
		/*
		theAccountDAO.addAccount(); 
		theMembershipDAO.addAccount();
		*/
		
		//close the context
		context.close();
		

	}

}
