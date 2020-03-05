package com.luv2code.springdemo;

import java.lang.reflect.Method;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		
		//Load Spring config file
		/*
		 * This will create all the classes as stipulated in the application context .xml file
		 */
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve the bean
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		//Coach theCoach = context.getBean("myCricketCoach", Coach.class);
		
		/**/
		System.out.println("");
		System.out.println("These are the methods in CricketCoach Class\n");
		Class c = theCoach.getClass();
		for (Method method : c.getDeclaredMethods()) {
		  
		    System.out.println(method.getName());
		  
		}
		
		
		
		
		System.out.println("");
		System.out.println("Working with beans");
		System.out.println("");
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune()); 
		
		/*
		 * This will only work if theCoach is a type CricketCoach not COACH
		 */
		System.out.println(theCoach.getEmailAddress());
	  System.out.println(theCoach.getTeam());
		theCoach.testInterfaceScope();
		System.out.println("");
		
		/*
		 * This will only work if theCoach is a type CricketCoach not COACH
		 */
		//theCoach.testInterfaceScope();
		
		//close the context
		context.close(); 

	}

}
