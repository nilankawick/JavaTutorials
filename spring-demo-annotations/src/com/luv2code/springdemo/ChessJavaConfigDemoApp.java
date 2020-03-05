 package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ChessJavaConfigDemoApp {

	public static void main(String[] args) {

		// Read the JAVA Spring Config File
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		System.out.println("");

		// get the bean from the spring container
		ChessCoach theCoach = context.getBean("chessCoach", ChessCoach.class);
		
		System.out.println("");

		// call a method via the bean
		System.out.println(theCoach.getDailyWorkout());
		// Dependency injection via a constructor method
		System.out.println(theCoach.getDailyFortune());
		System.out.println("");

		//Reading values from the property file
		System.out.println(theCoach.getEmail());
		System.out.println(theCoach.getTeam());

		// close the context
		context.close();

	}

}
