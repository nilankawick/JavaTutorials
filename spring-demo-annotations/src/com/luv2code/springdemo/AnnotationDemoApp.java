package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		// Read the Spring Config File
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("\nAnnotation \n");

		// get the bean from the spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach theCoach1 = context.getBean("badmintonCoach", Coach.class);
		Coach theCoach2 = context.getBean("athleticCoach", Coach.class);
		System.out.println("");

		// call a method via the bean
		System.out.println(theCoach.getDailyWorkout());
		// Dependency injection via a constructor method
		System.out.println(theCoach.getDailyFortune());
		System.out.println("");

		System.out.println(theCoach1.getDailyWorkout());
		// Dependency injection via a setter method
		System.out.println(theCoach1.getDailyFortune());
		System.out.println("");

		System.out.println(theCoach2.getDailyWorkout());
		// Dependency injection via Field Injection
		System.out.println(theCoach2.getDailyFortune());
		System.out.println("");

		// Used for examining property files
		SwimCoach theCoach3 = context.getBean("swimmer", SwimCoach.class);
		System.out.println(theCoach3.getDailyWorkout());
		// Dependency injection via Field Injection
		System.out.println(theCoach3.getDailyFortune());
		// Accessing Property infor
		System.out.println(theCoach3.getEmail());
		System.out.println(theCoach3.getTeam());
		System.out.println("");
		
		// Used for example of reading files
		Coach theCoach4 = context.getBean("boxer", Coach.class);
		System.out.println(theCoach4.getDailyWorkout());
		// Dependency injection via Field Injection
		System.out.println(theCoach4.getDailyFortune());

		// close the context
		context.close();

	}

}
