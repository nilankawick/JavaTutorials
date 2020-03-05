package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class ChessCoach implements Coach {

	private FortuneService fortuneService;
	
	// field level injections via a property files
	@Value("${foo.email}")
	private String email;
	@Value("${foo.team}")
	private String team;
	
	
	/*
	 * Implementation of DI through a Constructor 
	 */
	public ChessCoach(FortuneService aFortuneService) {
		System.out.println("DEBUG --> Chess Coach : Inside Constructor ChessCoach(FortuneService aFortuneService) ");
		this.fortuneService = aFortuneService;
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	@Override
	public String getDailyWorkout() {
		System.out.println("DEBUG --> Chess Coach : Inside getDailyWorkout()");
		return "Read and study some Chess Moves";
	}

	@Override
	public String getDailyFortune() {
		System.out.println("DEBUG --> Chess Coach : Inside getDailyFortune()");
		return this.fortuneService.getFortune();
	}

}
