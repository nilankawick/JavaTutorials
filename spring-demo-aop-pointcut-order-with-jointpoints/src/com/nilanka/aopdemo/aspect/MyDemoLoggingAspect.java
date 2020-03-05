package com.nilanka.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.nilanka.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	
	
	// POINT CUT EXPRESSION WITH A DEFINED ORDER FOR EXECUTION WITH JOINT POINTS //
	
	

	
	/**/
	@Before("com.nilanka.aopdemo.aspect.MyAopExpressions.forDAOPackageNoGetterSetter()")
	public void beforeVoidAddAccountAdvice(JoinPoint tmpJoinPoint){
		System.out.println("  ====> Executing @Before advice on method  - [Performing beforeVoidAddAccountAdvice()] -- Order - 2");
	
		// display method signature
		MethodSignature methoSig = (MethodSignature) tmpJoinPoint.getSignature();
		System.out.println("  \t====> Method Signature : "+methoSig);
		
		// display method arguments 
			//get the arguments
		Object[] args = tmpJoinPoint.getArgs();
			//loop through the arguments 
		for (Object tmpArg : args)
		{
		System.out.println("  \t====> Method Arguments : "+tmpArg);	
			
		// display actual object information, by downcasting
			if (tmpArg instanceof Account) {
				Account tmpAccount = (Account) tmpArg;
				System.out.println("\t\t====> Account name: " + tmpAccount.getName());
				System.out.println("\t\t====> Account level: " + tmpAccount.getLevel());
			}
		
		
		}
		
		
	
	}
	
	
	
	
	
}
