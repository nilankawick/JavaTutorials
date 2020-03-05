package com.nilanka.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
		
		// or we can use something like the following to show the method signature
		String method = tmpJoinPoint.getSignature().toShortString();
		System.out.println("  \t====> Method Signature to string : "+method);
		
		
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
			}else {
				System.out.println("\t\t====> Other Method Arguments details: " + tmpArg);
			}
		
		
		}
		
		
	
	}
	
	// add an advice for @AfterReturning on the findAccounts() method
	
	@AfterReturning(
			pointcut="execution(* com.nilanka.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="accountResults"
			)
	public void afterReturningFindAccountsAdvice(JoinPoint tmpJPoint, List<Account> accountResults ) {
		
		
		System.out.println("  \n====> Executing @AfterReturning advice on method com.nilanka.aopdemo.dao.AccountDAO.findAccounts(..) -- Order - 2");
		
		//method which we are advising on
		/**/
		MethodSignature tmpMethosig = (MethodSignature) tmpJPoint.getSignature();
		System.out.println("  \t====> Method Signature : "+tmpMethosig);
		
		String method = tmpJPoint.getSignature().toShortString();
		System.out.println("  \t====> Method Signature shortstring : "+method);
		
		
		// print out the results of the method call
		System.out.println("  \t====> Method return result : "+accountResults);
		
		
	}
	
	
	
	
	
	
}
