package com.luv2code.springdemo;

public class BaseballCoach implements Coach{
	
	//Define a private field for Dependency Injection
	private FortuneService fortuneService;
	
	//Creating a constructor for Injection of the fortuneService INTERFACE
	public BaseballCoach(FortuneService fortuneService) {
		System.out.println("DEBUG --> BaseballCoach() - Inside Constructor BaseballCoach() and creating Fortune ");
		this.fortuneService = fortuneService;
	}
	
	
	//Overriding methods in the Coach Interface 
	@Override
	public String getDailyWorkout(){
		return "Spend 30 minutes in the Batting cage";
		
	}

	@Override
	public String getDailyFortune() {  
		// Use my fortune service to get a fortune
		return this.fortuneService.getFortune(); 
		
	}
	
	

}
