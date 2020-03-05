package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {

		System.out.println("Application context file to load spring config....\n");
		// load Spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		System.out.println("\nSpring config loaded..\nRetrieving Beans\n");
		
		// retrieve a bean
		// *************************** the bean Id ** name of the interface of our implemented bean **** 
		Coach theCoach = context.getBean("myCoach", Coach.class);

		//System.out.println("");
		System.out.println("Generic Coach  specific IOC and DI\n");
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());

		// Calling the method that is made available via DI
		System.out.println(theCoach.getDailyFortune());
		
		//to check if we can access the method TEST() in TRACKCOACH when its not within the scope of the COACH interface
		/*
		 * The same would throw and compile error
		 */
	    //System.out.println(theCoach.testInterfaceScope());

		
		
		// Rugby Specific coach
		System.out.println("");
		System.out.println("Rugby Specific IOC and DI\n");
		
		// retrieve a bean
		theCoach = context.getBean("rugbyCoach", Coach.class);

		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());

		// Calling the method that is made available via DI
		System.out.println(theCoach.getDailyFortune());
		
		
		// Cricket Specific coach
				System.out.println("");
				System.out.println("Cricket Specific IOC and DI\n");
				
				// retrieve a bean
				theCoach = context.getBean("myCricketCoach", Coach.class);

				// call methods on the bean
				System.out.println(theCoach.getDailyWorkout());

				// Calling the method that is made available via DI
				System.out.println(theCoach.getDailyFortune());

		// close the context
		context.close();

	}

}
