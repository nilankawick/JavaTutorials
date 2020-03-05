package com.luv2code.springdemo;


//This is the dependency Class that implements the Dependency Interface
public class HappyFortuneService implements FortuneService {

	
	public HappyFortuneService(){
		System.out.println("DEBUG --> Inside HappyFortuneService No-Arg Constructor");
		System.out.println("DEBUG --> No arg constructor : "+ this.toString());
	}
	
	@Override
	public String getFortune() {
		System.out.println("DEBUG --> Inside getFortune()"+ this.toString());
		return "********Today is your lucky day!*********";
	
	}

	@Override
	public String toString() {
		return "HappyFortuneService [toString()=" + super.toString() + "]";
	}

	
	

}
