package com.nilanka.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	/*
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
	*/
	
	
	// add an advice for @AfterReturning on the findAccounts() method
	
	@AfterReturning(
			pointcut="execution(* com.nilanka.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="accountResults"
			)
	public void afterReturningFindAccountsAdvice(JoinPoint tmpJPoint, List<Account> accountResults ) {
		
		
		System.out.println("  \n====> Executing @AfterReturning advice on method com.nilanka.aopdemo.dao.AccountDAO.findAccounts(..) -- Order - 2");
		
		//method which we are advising on
		
		MethodSignature tmpMethosig = (MethodSignature) tmpJPoint.getSignature();
		System.out.println("  \t====> Method Signature : "+tmpMethosig);
		
		String method = tmpJPoint.getSignature().toShortString();
		System.out.println("  \t====> Method Signature shortstring : "+method);
		
		
		// print out the results of the method call
		System.out.println("  \t====> Method return result [PRE CHANGE] : "+accountResults);
		
		//modifying return data before it returns to the calling program
		
		// convert the account names to uppercase
		convertAccountNameToUpperCase(accountResults);
		System.out.println("  \t====> Method return result [POST CHANGE] : "+accountResults);
		
		
		
		
	}

	private void convertAccountNameToUpperCase(List<Account> accountResults) {
		
		// loop through the accounts 
		for (Account tmpAcccounts : accountResults) {
			
			//get the uppercase
			String theUpperName = tmpAcccounts.getName().toUpperCase();
			
			// update the account name
			tmpAcccounts.setName(theUpperName);
		}
		
	}
	
	
	//add an advice for @AfterThrowing on the findAccounts() method
	
	@AfterThrowing(
			pointcut="execution(* com.nilanka.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="tmpExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint tmpJoinPoint, Throwable tmpExc) {
		
		//print out which method we are advising on
		MethodSignature tmpMethosig = (MethodSignature) tmpJoinPoint.getSignature();
		System.out.println("  \n====> Executing @AfterThrowing on Method Signature : "+tmpMethosig);
		//log the exception 
		System.out.println("  \n\t====> AfterThrowing Exception is - "+tmpExc);
		
		
		
	}
	
	// add an advice for @After(Final) on the findAccounts() method
	/*
	 * After(final) will run regardless of any exception or successful execution of particular method or code block
	 * In the event of an exception it will run before @Afterthrowing advice, if there is a @AfterAdvice 
	 * in the event of an success it will run before @AfterReturning
	 */
	@After("execution(* com.nilanka.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint tmpJoinPoint) {
		//print out which method we are advising on
		MethodSignature tmpMethosig = (MethodSignature) tmpJoinPoint.getSignature();
		System.out.println("  \n====> Executing @AfterFinally on Method Signature : "+tmpMethosig);
		
	}
	
	
	
	
	
}
