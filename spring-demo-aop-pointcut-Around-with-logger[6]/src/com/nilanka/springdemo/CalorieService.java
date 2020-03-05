package com.nilanka.springdemo;

import org.springframework.stereotype.Component;

@Component
public class CalorieService implements CalorieCounter {

	@Override
	public String getCalories() {
		System.out.println("DEBUG LOG : INSIDE getCalories() of CalorieService Class of CalorieCounter Interface***");
		return "1900 calories per day\n";
	}

}
