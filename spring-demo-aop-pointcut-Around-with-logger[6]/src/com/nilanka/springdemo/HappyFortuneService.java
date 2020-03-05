package com.nilanka.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	
	@Override
	public String getFortune() {
		System.out.println("DEBUG LOG : INSIDE Happyfortune Service getFortune()***");
		return "Fortune - Milk a day!!!!!\n";
		
	}

}
