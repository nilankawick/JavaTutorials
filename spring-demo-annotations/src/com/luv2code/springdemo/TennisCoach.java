package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component("tennisCoach")
@Component
public class TennisCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public TennisCoach(){
		System.out.println("DEBUG --> Tennis Coach: Inside No-Args Constructor");
	}
	
	//define my init method
	@PostConstruct
	public void doMyStartUpStuff(){
		System.out.println("DEBUG --> Tennis Coach: Inside doMyStartUpStuff()");;
	}
	
	//define my destroy method
	@PreDestroy
	public void doMyCleanUpStuff(){
		System.out.println("DEBUG --> Tennis Coach: Inside doMyCleanUpStuff()");;
	}
	
	// DI via Constructor method
	/*
	 * When we try to autowire a dependency on a Constructor and we are to reference a particular 
	 * interface implementation we use the @Qualifier with the method call 
	 */
	@Autowired	
	public TennisCoach(@Qualifier("tennisDBFortuneService") FortuneService thefortuneService) {
		System.out.println("DEBUG --> Tennis Coach: Inside Constructor TennisCoach(FortuneService fortuneService)");
		System.out.println("DEBUG --> Tennis Coach: example of DI via Constructor method");
		this.fortuneService = thefortuneService;
	}

	@Override
	public String getDailyWorkout() {
		System.out.println("DEBUG --> Tennis Coach: Inside getDailyWorkout()");
		return "Practice your volley";
	}

	@Override
	public String getDailyFortune() {
		System.out.println("DEBUG --> Tennis Coach: Inside getDailyFortune()");
		return this.fortuneService.getFortune()+"Win Big in the next tennis Match";		
	}

}
