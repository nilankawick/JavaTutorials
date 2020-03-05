package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		System.out.println("Inside HappyFortuneService.getFortune() ");
		return "Happy Fortune Service for Badminton : Today is your lucky day!!!";
	}

}
