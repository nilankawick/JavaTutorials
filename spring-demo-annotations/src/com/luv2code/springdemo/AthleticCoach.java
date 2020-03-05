package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class AthleticCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService thefortuneService; 

	public AthleticCoach(){
		System.out.println("Athletic: Inside No-Args Constructor");
		 
		System.out.println("Athletic: DI via Field Injection");
	}
	
	@Override
	public String getDailyWorkout() {
		System.out.println("Athletic Coach: Inside getDailyWorkout()");
		return "Do some explosive power workouts"; 
	}

	@Override
	public String getDailyFortune() {
		System.out.println("Athletic Coach: Inside getDailyFortune()");
		return this.thefortuneService.getFortune()+" , you can run with some wind assistance";
	}

}
