package com.luv2code.springdemo;

import java.util.Arrays;
import java.util.Random;

public class FortuneDirectory implements FortuneService {

	private String[] fortunes = {"You are winner today","Get a lottery and win big","more money will be yours","You are lucky today"};
	
	
	private Random rand = new Random();
	private int y = rand.nextInt(fortunes.length);
	
	
	
	public int getY() {
		return y;
	}


	@Override
	public String getFortune() {
		System.out.println("DEBUG --> Inside getFortune() "+ this.toString());
		return fortunes[this.getY()];
	}


	@Override
	public String toString() {
		return "FortuneDirectory [fortunes=" + Arrays.toString(fortunes) + ",\nPicking random item =" + y + "]";
	}

	
}
