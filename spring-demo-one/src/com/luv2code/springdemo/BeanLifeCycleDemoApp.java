package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		
		// Load the spring Configuration File
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		
		// Retrieve Bean from Spring Container
		Coach theCoach1 = context.getBean("myCoach", Coach.class);
		
		System.out.println(theCoach1.getDailyWorkout());
		System.out.println(theCoach1.getDailyFortune());
		
		
		//Closing Context
		context.close();
		
		
		
		
		

	}

}
