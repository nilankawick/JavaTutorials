package com.nilanka.springdemo;

import org.springframework.stereotype.Component;

@Component("InjuryAssessment")
public class InjuryService implements InjuryUpdate {

	@Override
	public String getInjuryUpdate() {
		
		return "No Injury as per initial scanning... Awaiting detailed report \n";
	}

}
