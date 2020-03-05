package com.nilanka.javaconfigdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		//read Spring Java Class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
				
		//get the bean from the spring container
		CricketCoach tmpCoach = context.getBean("cricketCoach", CricketCoach.class);
		
		//call a method on the bean
		System.out.println("\n*****");
		System.out.println(tmpCoach.getDailyWorkout());
		System.out.println(tmpCoach.getDailyFortune());
		System.out.println("Email - "+tmpCoach.getEmail());
		System.out.println("Team - "+tmpCoach.getTeam());
		/*
		
		System.out.println(tmpCoach.getDailyCalories());
		System.out.println(tmpCoach.getDailyInjuryUpdate());
		*/
		
		//close the container
		context.close();

	}

}
