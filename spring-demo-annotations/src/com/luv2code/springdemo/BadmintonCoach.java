package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BadmintonCoach implements Coach {
	
	
	private FortuneService fortuneService;
	
	/**/
	public BadmintonCoach(){
		System.out.println("DEBUG --> Badminton Coach: Inside No-Args Constructor");
		
	}
	
	
	// DI via Constructor method
	/*
	@Autowired
	public BadmintonCoach(@Qualifier("happyFortuneService") FortuneService thefortuneService) {
		System.out.println("Badminton Coach: Inside Constructor BadmintonCoach(FortuneService fortuneService)");
		this.fortuneService = thefortuneService;
	}
	*/
	
	// DI via setter method
	@Autowired
	@Qualifier("happyFortuneService") 
	public void setAFortuneServiceForBadminton(FortuneService thefortuneService) {
		
		System.out.println("DEBUG --> Badminton Coach: Inside setAFortuneServiceForBadminton(FortuneService fortuneService)");
		System.out.println("DEBUG --> Badminton Coach: example of DI via setter method");
		this.fortuneService = thefortuneService;
	}

	@Override
	public String getDailyWorkout() {
		System.out.println("DEBUG --> Badminton Coach: Inside getDailyWorkout");
		
		return "Shadow drills on court movement";
	}

	

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		System.out.println("DEBUG --> Badminton Coach: Inside getDailyFortune");
		return this.fortuneService.getFortune()+" You are going to smash like Thor";
	}

	/*
	@Override
	public String getDailyFortune() {
		System.out.println("Badminton Coach: Inside getDailyFortune");
		return "You are going to smash like Thor";
	}
	*/
	

}
