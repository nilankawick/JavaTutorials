package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class JavaConfigDemoApp {

	public static void main(String[] args) {

		// Read the JAVA Spring Config File
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		System.out.println("");

		// get the bean from the spring container
		Coach theCoach = context.getBean("chessCoach", Coach.class);
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
