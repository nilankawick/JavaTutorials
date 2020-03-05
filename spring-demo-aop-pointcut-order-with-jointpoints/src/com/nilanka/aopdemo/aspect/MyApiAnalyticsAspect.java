package com.nilanka.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(6)
public class MyApiAnalyticsAspect {
	// POINT CUT EXPRESSION WITH A DEFINED ORDER FOR EXECUTION WITH JOINT POINTS //
	
	/**/
	@Before("com.nilanka.aopdemo.aspect.MyAopExpressions.forDAOPackageNoGetterSetter()")
	public void performAPIAnalytics(){
		System.out.println("  ====> Executing @Before advice on method - [Performing performAPIAnalytics()]-- Order - 6");
	}

}
