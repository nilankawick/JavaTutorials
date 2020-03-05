package com.luv2code.springdemo;

public class RugbyHappyFortuneService implements FortuneService {

	
	public RugbyHappyFortuneService(){
		System.out.println("DEBUG --> Inside RugbyHappyFortuneService No-Arg Constructor");
		System.out.println("DEBUG --> No arg constructor : "+ this.toString());
	}
	@Override
	public String getFortune() {
		System.out.println("DEBUG --> Inside getFortune() "+ this.toString());
		return "you won the rugby match and free pints all around!!! +"+"---"+this.test();
	}
	
	public String test(){
		return "This shoud not be available via the interface";
	}

	@Override
	public String toString() {
		return "RugbyHappyFortuneService [toString()=" + super.toString() + "]";
	}
	
	

}
