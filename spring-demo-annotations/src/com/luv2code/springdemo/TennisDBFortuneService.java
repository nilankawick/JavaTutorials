package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class TennisDBFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		System.out.println("Inside TennisDBFortuneService.getFortune() ");
		return "Your tennis coach is going to be Nadal!!!!!";
	}

}
