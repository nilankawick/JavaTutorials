package com.nilanka.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {
	
	//@Autowired
	private FortuneService tmpFortuneService;
	
	//@Autowired
	private CalorieCounter tmpcalorieCounter;
	
	/*
	 * DI via fieldlevel injection
	 */
	@Autowired
	@Qualifier("InjuryAssessment")
	private InjuryUpdate injuryUpdate;
	
	/*
	 * DI via fieldlevel injection
	 */
	@Autowired
	@Qualifier("RehabReport")
	private InjuryUpdate detailedInjuryUpdate;
	
	
	public TennisCoach() {
		System.out.println("DEBUG LOG : INSIDE TennisCoach NO ARG Constructor***");
		
	}
	
	//define init
	@PostConstruct
	 public void initializingMethod(){
		 System.out.println(">> Tennis Coach Custom Init Method\n");
	 }
	
	
	//define destroy
	@PreDestroy
	public void destroyMethod(){
		 System.out.println(">> Tennis Coach Custom Clean Up Method\n");
	 }
	
	
	/*
	 * DI via Constructor Injection
	 * Using annotation --> Autowired
	 */
	
	/**/
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		System.out.println("DEBUG LOG : INSIDE TennisCoach Constructor***");
		this.tmpFortuneService = theFortuneService;
	}
	
	
	/*
	 * DI via setter Injection
	 * Using annotation --> Autowired
	 */
	
	/**/
	@Autowired
	public void setCalorieCounter(CalorieCounter theCalorieCounter) {
		System.out.println("DEBUG LOG : INSIDE setCalorieCounter DI via setter method***");
		this.tmpcalorieCounter = theCalorieCounter;
	}
	

	
	public String testObjectScope(){
		return "This is method that is not part of the interface";
	}
	
	@Override
	public String getDailyWorkout() {
		System.out.println("\nDEBUG LOG : INSIDE Coach Class getDailyWorkout Method***");
		return "Back hand volley practice session\n";
	}

	@Override
	public String getDailyFortune() {
		
		return this.tmpFortuneService.getFortune();
	}

	@Override
	public String getDailyCalories() {
		System.out.println("DEBUG LOG : INSIDE TennisCoach Class and calling getDailyCalories()");
		return this.tmpcalorieCounter.getCalories();
	}

	@Override
	public String getDailyInjuryUpdate() {
		System.out.println("DEBUG LOG : INSIDE TennisCoach Class and calling InjuryService & rehabService getInjurUpdate()***");
		String injuryReport = this.injuryUpdate.getInjuryUpdate() + this.detailedInjuryUpdate.getInjuryUpdate();
		return injuryReport;
	}

}
