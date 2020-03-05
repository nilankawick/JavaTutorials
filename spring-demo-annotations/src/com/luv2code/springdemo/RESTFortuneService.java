package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class RESTFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		System.out.println("Inside RESTFortuneService.getFortune() ");
		return "REST Fortune Service";
	}

}
