package com.luv2code.springdemo;

public class MyApp {

	public static void main(String[] args) {
		//Create the object
		Coach thecoach = new RugbyCoach();
		

		// Use the object
		System.out.println(thecoach.getDailyWorkout());
		System.out.println(thecoach.getDailyFortune());
		
	}

}
