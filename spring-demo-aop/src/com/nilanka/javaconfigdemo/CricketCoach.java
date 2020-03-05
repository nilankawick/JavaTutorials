package com.nilanka.javaconfigdemo;

import org.springframework.beans.factory.annotation.Value;

//@Component
public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	//no-arg constructor
	public CricketCoach() {
		System.out.println("DEBUG LOG : INSIDE Cricket Coach NO ARG Constructor***");
	}
	
	// DI via constructor injection
	//@Autowired
	public CricketCoach(FortuneService tmpfortuneService) {
		System.out.println("DEBUG LOG : INSIDE Cricket Coach public CricketCoach(FortuneService tmpfortuneService) Constructor***");
		this.fortuneService = tmpfortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		
		return "Batting Net session for 1 hours ....\n";
	}

	@Override
	public String getDailyFortune() {
		
		return this.fortuneService.getFortune();
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}
	
	
	
/*
	@Override
	public String getDailyCalories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDailyInjuryUpdate() {
		// TODO Auto-generated method stub
		return null;
	}

	*/
	
}
