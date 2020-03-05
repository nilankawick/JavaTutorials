package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		// Load the spring Configuration File
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		//System.out.println(context);
		// Retrieve Bean from Spring Container
		
		/*
		 * Example of a singleton
		 * 
		 * this is where no matter what we initiate we are referring to the same object since the bean scope 
		 * property is its default property which is singleton 
		 */
		
		boolean isSame;
		/**/
		
		Coach theCoach1 = context.getBean("myCoach", Coach.class);
		Coach theCoach2 = context.getBean("myCoach", Coach.class);
		/**/
		isSame = (theCoach1 == theCoach2);
		System.out.println("\n checking if we are point to the same object -- "+isSame);
		
		System.out.println("\n Location from Coach1 -- "+theCoach1);
		System.out.println("\n Location from Coach2 -- "+theCoach2);
		
		
		
		System.out.println("\nBeanscope = Prototype");
		
		/*
		 * 
		 */
		Coach theCoach3 = context.getBean("Coach", Coach.class);
		Coach theCoach4 = context.getBean("Coach", Coach.class);
		
		
		/**/
		isSame = (theCoach3 == theCoach4);
		System.out.println("\n checking if we are point to the same object -- "+isSame);
		
		System.out.println("\n Location from Coach1 -- "+theCoach3);
		System.out.println("\n Location from Coach2 -- "+theCoach4);
		
		
		
		//String dailyWorkout = theCoach1.getDailyWorkout();
		//System.out.println(dailyWorkout);
		//String dailyFortune =theCoach1.getDailyFortune();
		//System.out.println(dailyFortune);
		
		
		//Closing Context
		context.close();
		
		
		
		
		

	}

}
