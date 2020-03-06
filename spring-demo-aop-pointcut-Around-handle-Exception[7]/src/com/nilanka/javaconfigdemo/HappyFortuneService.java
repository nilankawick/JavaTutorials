package com.nilanka.javaconfigdemo;


//@Component
public class HappyFortuneService implements FortuneService {

	
	@Override
	public String getFortune() {
		System.out.println("DEBUG LOG : INSIDE getFortune()***");
		return "Fortune - You have been selected to the cricket team!!!!!\n";
		
	}

}
