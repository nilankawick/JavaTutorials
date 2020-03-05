package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		// Read the Spring Config File
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("");

		System.out.println("Singelton Scope");
		// Retrieving a Bean
		Coach theCoachA = context.getBean("tennisCoach", Coach.class);
		Coach theCoachB = context.getBean("tennisCoach", Coach.class);

		// Check to see if they are the same i.e - in singleton scope

		boolean result = (theCoachA == theCoachB);
		System.out.println("Pointing to the same object - " + result);
		System.out.println("Memory location for Bean 1 - " + theCoachA);
		System.out.println("Memory location for Bean 1 - " + theCoachB);

		System.out.println("\nPrototype Scope");
		// Retrieving a Bean
		Coach theCoachC = context.getBean("athleticCoach", Coach.class);
		Coach theCoachD = context.getBean("athleticCoach", Coach.class);

		// Check to see if they are the same i.e - in prototype scope

		result = (theCoachC == theCoachD);
		System.out.println("Pointing to the same object - " + result);
		System.out.println("Memory location for Bean 1 - " + theCoachC);
		System.out.println("Memory location for Bean 1 - " + theCoachD);

		// Call Method via Bean

		// Close Context
		context.close();

	}

}
