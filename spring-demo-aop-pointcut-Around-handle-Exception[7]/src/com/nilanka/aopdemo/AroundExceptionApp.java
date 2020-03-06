package com.nilanka.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nilanka.aopdemo.dao.AccountDAO;
import com.nilanka.aopdemo.dao.MembershipDAO;
import com.nilanka.aopdemo.service.TrafficFortuneService;

public class AroundExceptionApp {
	
	
	/*
	 * the next couple of lines sets up the logger that will be used for printing out print prompts
	 * replace myLogger.info() with System.out.println();
	 */
	
	private static Logger myLogger = Logger.getLogger(AroundExceptionApp.class.getName());
	

	public static void main(String[] args) {
		
		
		
		
		myLogger.info("**** AOP Around Advice EXAMPLE **** \n");
		myLogger.info("\n");
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		
		//get the bean from the spring container
		myLogger.info(" *** STEP 1 - Getting the BEANS ***");
		TrafficFortuneService tmpTrafficFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		
		//
		myLogger.info("\n Main App : Around Advice");
		myLogger.info("Calling get fortune\n");
		
		
		boolean tripWire = true;
		
		String data = tmpTrafficFortuneService.getFortune(tripWire);
		
		myLogger.info("My fortune is :"+ data +"\n");
		
		myLogger.info("Main App: Around Advice DONE");
		
		
		//close the context
		context.close();
		

	}

}
