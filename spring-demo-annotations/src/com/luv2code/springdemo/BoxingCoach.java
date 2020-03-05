package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("boxer")
public class BoxingCoach implements Coach {

	/*
	 * Field level injection 
	 */
	@Autowired
	@Qualifier("fileFortuneService")
	private FortuneService thefortuneService; 
	
	public BoxingCoach(){
		System.out.println("DEBUG --> Boxing Coach: Inside No-Args Constructor");
		System.out.println("DEBUG --> Boxing Coach: DI via Field Injection");
	}
	
	@Override
	public String getDailyWorkout() {
		System.out.println("DEBUG --> Boxing Coach: Inside getDailyWorkout()");
		return "Do some shadow boxing"; 
	}

	@Override
	public String getDailyFortune() {
		System.out.println("DEBUG --> Boxing Coach: Inside getDailyFortune()");
		return thefortuneService.getFortune() + " - Box away!!!!";
	}

}
