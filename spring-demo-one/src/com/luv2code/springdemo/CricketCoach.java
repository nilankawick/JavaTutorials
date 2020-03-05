package com.luv2code.springdemo;

public class CricketCoach implements Coach {
	
	//Define a private field for Dependency Interface
	private FortuneService fortuneService;
	
	//new fields to hold email, team name
	private String emailAddress;
	private String team;
	
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("DEBUG--> CricketCoach - Inside setter method - setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("DEBUG --> CricketCoach: Inside setter method - setTeam");
		this.team = team;
	}

	// no args constructor
	public CricketCoach() {
		System.out.println("DEBUG --> CricketCoach - inside no-arg constructor");
	} 
	
	// Creating an injection via the setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("DEBUG --> CricketCoach: inside the setter-method: setFortuneService "); 
		this.fortuneService = fortuneService;
		System.out.println("DEBUG --> CricketCoach - Inside setFortuneService(FortuneService fortuneService) and creating Fortune : "+ fortuneService);
		//System.out.println(fortuneService);
		//this.testInterfaceScope();
	}

	@Override
	public String getDailyWorkout() {
		System.out.println("DEBUG --> CricketCoach: inside getDailyWorkout() ");  
		return "Fast bowling for 15 minutes";
	}

	

	@Override
	public String getDailyFortune() {
		System.out.println("DEBUG --> CricketCoach: inside getDailyFortune() "); 
		return this.fortuneService.getFortune();
	}
	
	public void testInterfaceScope(){
		System.out.println("This is a test");
	}

}
