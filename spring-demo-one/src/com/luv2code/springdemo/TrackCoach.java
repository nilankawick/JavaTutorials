package com.luv2code.springdemo;

public class TrackCoach implements Coach {

	// Define a private field for Dependency Interface
	private FortuneService fortuneService;

	//Creating a constructor for Injection of the fortuneService INTERFACE
	public TrackCoach(FortuneService fortuneService) {
		System.out.println("DEBUG --> TrackCoach - Inside Constructor TrackCoach(FortuneService fortuneService)");
		System.out.println("DEBUG --> TrackCoach - Inside Constructor TrackCoach(FortuneService fortuneService) and creating Fortune : "+ fortuneService);
		this.fortuneService = fortuneService;
	}

	// Overriding the interface methods for Coach

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.luv2code.springdemo.Coach#getDailyWorkout()
	 */
	@Override
	public String getDailyWorkout() {
		System.out.println("DEBUG --> TrackCoach - Inside getDailyWorkout()");
		return "Run a hard 5K";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.luv2code.springdemo.Coach#getDailyFortune()
	 */
	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		System.out.println("DEBUG --> TrackCoach - Inside getDailyFortune() ");
		return "Just do it, " + this.fortuneService.getFortune();
	}
	
	public String testInterfaceScope(){
		System.out.println("DEBUG --> TrackCoach - Inside testInterfaceScope() ");
		return "This is to test the scope of the method outside of the Interface scope";
	}
	
	/*
	 * 
	 * we will be adding a 
	 * a. init method
	 * b. a destroy method
	 * 
	 * both of the above have to be startup methods
	 * 
	 * 
	 */

		public void doMyStartUpStuff(){
			System.out.println("TrackCoach - Inside doMyStartUpStuff() ");
		}
		
		public void doMyDestroyStuff(){
			System.out.println("TrackCoach - Inside doMyDestroyStuff() ");
		}
		
		
}
