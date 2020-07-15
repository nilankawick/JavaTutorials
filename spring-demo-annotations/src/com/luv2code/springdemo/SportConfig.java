package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.luv2code.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {

	//Field level injections via a property file
	
	 // define bean for SadFortune Service
	//Method name will be the bean ID, in this example the Bean ID will be the Method name sadFortuneService
	@Bean
	public FortuneService sadFortuneService(){
		return new SadFortuneService();
	}
	// define bean for our swim coach and inject dependency through the constructor 
	@Bean
	public Coach chessCoach(){
		 return new ChessCoach(sadFortuneService());
		 
	}
	
	/**/
	@Bean 
	public FortuneService randomFortuneService(){
		return new RandomFortuneService();
	}
	
	
	@Bean 
	public FortuneService happyFortuneService(){
		return new HappyFortuneService();
	}
	
	@Bean
	public Coach athleticCoach(){
		 return new AthleticCoach();
		 
	}
	
	@Bean
	public Coach badmintonCoach(){
		 return new BadmintonCoach();
		 
	}
	
	
	
	@Bean
	public Coach swimCoach(){
		 return new SwimCoach();
		 
	}
	/*
	@Bean
	public Coach boxingCoach(){
		 return new BoxingCoach();
		 
	}
	*/
	
	//
}
