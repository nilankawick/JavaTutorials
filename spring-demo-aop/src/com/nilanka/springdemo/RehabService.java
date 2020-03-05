package com.nilanka.springdemo;

import org.springframework.stereotype.Component;

@Component("RehabReport")
public class RehabService implements InjuryUpdate {

	@Override
	public String getInjuryUpdate() {
		
		return "INJURED.. need two weeks of rehab";
	}

}
