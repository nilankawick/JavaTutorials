package com.luv2code.springdemo;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
//@PropertySource("fortune.properties")
public class RandomFortuneService implements FortuneService{

	
	@Value("${foo.randomFortunes}")
	private String[] randomFortunes;
	
	/*
	 * base.randomFortunes=You are winner today,Get a lottery and win big,more money will be yours,You are lucky today,Got a weak oponent,The first match is a walkover,Coach is going to give u  some juice

	 */
	
	
	/**/
	private Random rand = new Random();
	private int y;
	
	
	/*
	public int getY() {
		return y;
	}
*/
	

	@Override
	public String getFortune() {
		System.out.println("DEBUG --> Inside RandomFortuneService.getFortune() ");
		y = rand.nextInt(randomFortunes.length);
		return randomFortunes[y];
		//return randomFortunes;
	}


	/**/
	@Override
	public String toString() {
		return "DEBUG --> FortuneDirectory [fortunes=" + Arrays.toString(randomFortunes) + ",Picking random item =" + y + "]";
	}
	

	
}
