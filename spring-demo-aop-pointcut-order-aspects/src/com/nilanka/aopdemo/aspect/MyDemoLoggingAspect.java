package com.nilanka.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	
	
	// POINT CUT EXPRESSION WITH A DEFINED ORDER FOR EXECUTION //
	
	

	
	/**/
	@Before("com.nilanka.aopdemo.aspect.MyAopExpressions.forDAOPackageNoGetterSetter()")
	public void beforeVoidAddAccountAdvice(){
		System.out.println("  ====> Executing @Before advice on method  - [Performing beforeVoidAddAccountAdvice()] -- Order - 2");
	}
	
	
	
	
	
}
