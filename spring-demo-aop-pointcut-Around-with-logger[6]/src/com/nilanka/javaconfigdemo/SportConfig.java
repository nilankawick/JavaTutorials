package com.nilanka.javaconfigdemo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.nilanka.javaconfigdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {

	//define bean for happy fortune service
	@Bean
	public FortuneService theFortuneService(){
		return new HappyFortuneService();
	}
	
	//define bean for out Cricket Coach and inject dependency
	@Bean
	public Coach cricketCoach(){
		CricketCoach myCricCoach = new CricketCoach(theFortuneService());
		return myCricCoach;
	}
	
	
	
}
