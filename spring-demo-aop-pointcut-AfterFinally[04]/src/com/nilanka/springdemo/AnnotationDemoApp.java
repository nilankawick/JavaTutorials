package com.nilanka.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		//read Spring Config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
				
		//get the bean from the spring container
		System.out.println("DEBUG LOG : Getting TennisCoach Bean***");
		Coach tmpCoach = context.getBean("tennisCoach", Coach.class);
		
		//call a method on the bean
		System.out.println("DEBUG LOG : Accessing Tennish Coach Methods***");
		System.out.println(tmpCoach.getDailyWorkout());
		System.out.println(tmpCoach.getDailyFortune());
		System.out.println(tmpCoach.getDailyCalories());
		System.out.println(tmpCoach.getDailyInjuryUpdate());
		//close the container
		context.close();

	}

}
