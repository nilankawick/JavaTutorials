package com.luv2code.springdemo;

public class RugbyCoach implements Coach {

	//Define a private field for Dependency interface
	//private FortuneService fortuneService = new RugbyHappyFortuneService();
	private FortuneService fortuneService;
	
	public RugbyCoach() {
		System.out.println("DEBUG --> RugbyCoach - Inside  no args constructor");
	}
	

	//Creating a constructor for Injection of the fortuneService INTERFACE
	public RugbyCoach(FortuneService fortuneService) {
		System.out.println("DEBUG --> TrackCoach - Inside Constructor RugbyCoach(FortuneService fortuneService)");
		System.out.println("DEBUG --> TrackCoach - Inside Constructor RugbyCoach(FortuneService fortuneService) and creating Fortune : "+ fortuneService);
		this.fortuneService = fortuneService;
	}
	
	// Overriding the interface methods for Coach
	
	/*
	 * (non-Javadoc)
	 * @see com.luv2code.springdemo.Coach#getDailyWorkout()
	 */
	@Override
	public String getDailyWorkout() {
		System.out.println("DEBUG --> RugbyCoach - Inside  getDailyWorkout()");
		return "Do a weight session, followed by ball handling session";
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.luv2code.springdemo.Coach#getDailyFortune()
	 */
	
	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		System.out.println("DEBUG --> RugbyCoach - Inside  getDailyFortune()");
		return this.fortuneService.getFortune();
		
	}

}
