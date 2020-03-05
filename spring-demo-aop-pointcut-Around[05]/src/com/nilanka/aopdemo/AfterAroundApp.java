package com.nilanka.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nilanka.aopdemo.dao.AccountDAO;
import com.nilanka.aopdemo.dao.MembershipDAO;
import com.nilanka.aopdemo.service.TrafficFortuneService;

public class AfterAroundApp {

	public static void main(String[] args) {
		
		
		
		
		System.out.println("**** AOP Around Advice EXAMPLE **** \n");
		System.out.println();
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		
		//get the bean from the spring container
		System.out.println(" *** STEP 1 - Getting the BEANS ***");
		TrafficFortuneService tmpTrafficFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		
		//
		System.out.println("\n Main App : Around Advice");
		System.out.println("Calling get fortune\n");
		
		String data = tmpTrafficFortuneService.getFortune();
		
		System.out.println("My fortune is :"+ data +"\n");
		
		System.out.println("Main App: Around Advice DONE");
		
		
		//close the context
		context.close();
		

	}

}
