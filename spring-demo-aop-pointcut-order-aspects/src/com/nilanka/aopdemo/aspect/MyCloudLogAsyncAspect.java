package com.nilanka.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-1)
public class MyCloudLogAsyncAspect {
	
	// POINT CUT EXPRESSION WITH A DEFINED ORDER FOR EXECUTION //
	
	/**/
	@Before("com.nilanka.aopdemo.aspect.MyAopExpressions.forDAOPackageNoGetterSetter()")
	public void logToCloundAsync(){
		System.out.println("  ====> Executing @Before advice on method - [Performing logToCloundAsync()] -- Order - (-1)");
	
	}

}
