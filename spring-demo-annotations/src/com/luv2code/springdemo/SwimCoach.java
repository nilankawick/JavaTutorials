package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("swimmer")
//@PropertySource("sport.properties")
public class SwimCoach implements Coach {

	
	 // Dependency injection via Field Injection 
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService thefortuneService; 
	
	//Accessing property values through annotations
	@Value("${foo.email}")
	private String email;
	@Value("${foo.team}")
	private String team;
	
	public String getEmail() {
		return email;
	}
	
	public String getTeam() {
		return team;
	}

	public SwimCoach(){
		System.out.println("DEBUG --> Swim Coach: Inside No-Args Constructor");
		System.out.println("DEBUG --> Swim Coach: DI via Field Injection");
	}
	
	@Override
	public String getDailyWorkout() {
		System.out.println("DEBUG --> Swim Coach: Inside getDailyWorkout()");
		return "Swim 10 lengths";
	}

	@Override
	public String getDailyFortune() {
		System.out.println("DEBUG --> Swim Coach: Inside getDailyFortune()");
		return this.thefortuneService.getFortune()+" ,Swim Away!!!!!";
	}

}
