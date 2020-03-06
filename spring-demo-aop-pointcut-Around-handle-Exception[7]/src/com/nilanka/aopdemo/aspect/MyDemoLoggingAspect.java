package com.nilanka.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.nilanka.aopdemo.Account;
import com.nilanka.aopdemo.AroundLoggerApp;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	/*
	 * the next couple of lines sets up the logger that will be used for printing out print prompts
	 * replace myLogger.info() with System.out.println();
	 */
	private Logger myLogger = Logger.getLogger(getClass().getName());

	
	
	// POINT CUT EXPRESSION WITH A DEFINED ORDER FOR EXECUTION WITH JOINT POINTS //	
	/*
	@Before("com.nilanka.aopdemo.aspect.MyAopExpressions.forDAOPackageNoGetterSetter()")
	public void beforeVoidAddAccountAdvice(JoinPoint tmpJoinPoint){
		myLogger.info("  ====> Executing @Before advice on method  - [Performing beforeVoidAddAccountAdvice()] -- Order - 2");
	
		// display method signature
		MethodSignature methoSig = (MethodSignature) tmpJoinPoint.getSignature();
		myLogger.info("  \t====> Method Signature : "+methoSig);
		
		// or we can use something like the following to show the method signature
		String method = tmpJoinPoint.getSignature().toShortString();
		myLogger.info("  \t====> Method Signature to string : "+method);
		
		
		// display method arguments 
			//get the arguments
		Object[] args = tmpJoinPoint.getArgs();
			//loop through the arguments 
		for (Object tmpArg : args)
		{
		myLogger.info("  \t====> Method Arguments : "+tmpArg);	
			
		// display actual object information, by downcasting
			if (tmpArg instanceof Account) {
				Account tmpAccount = (Account) tmpArg;
				myLogger.info("\t\t====> Account name: " + tmpAccount.getName());
				myLogger.info("\t\t====> Account level: " + tmpAccount.getLevel());
			}else {
				myLogger.info("\t\t====> Other Method Arguments details: " + tmpArg);
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
		
		
		myLogger.info("  \n====> Executing @AfterReturning advice on method com.nilanka.aopdemo.dao.AccountDAO.findAccounts(..) -- Order - 2");
		
		//method which we are advising on
		
		MethodSignature tmpMethosig = (MethodSignature) tmpJPoint.getSignature();
		myLogger.info("  \t====> Method Signature : "+tmpMethosig);
		
		String method = tmpJPoint.getSignature().toShortString();
		myLogger.info("  \t====> Method Signature shortstring : "+method);
		
		
		// print out the results of the method call
		myLogger.info("  \t====> Method return result [PRE CHANGE] : "+accountResults);
		
		//modifying return data before it returns to the calling program
		
		// convert the account names to uppercase
		convertAccountNameToUpperCase(accountResults);
		myLogger.info("  \t====> Method return result [POST CHANGE] : "+accountResults);
		
		
		
		
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
		myLogger.info("  \n====> Executing @AfterThrowing on Method Signature : "+tmpMethosig);
		//log the exception 
		myLogger.info("  \n\t====> AfterThrowing Exception is - "+tmpExc);
		
		
		
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
		myLogger.info("  \n====> Executing @AfterFinally on Method Signature : "+tmpMethosig);
		
	}
	
	
	//An example of AROUND ADVICE TYPES
	/*
	 * Key concepts
	 * Proceeding JoinPoint --> this is a handle to the target method.
	 * For example , the below @Around advice..
	 * tmpProceedingJP gives access to the getFortune() method when the code execution 
	 * is on the code block below
	 * 
	 */
	@Around("execution(* com.nilanka.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint tmpProceedingJP) throws Throwable {
	
		//print out the method that we are advising on 
		MethodSignature tmpMethosig = (MethodSignature) tmpProceedingJP.getSignature();
		myLogger.info("  \n====> Executing @Around Advice on Method Signature : "+tmpMethosig);
		
		//calculate the time taken to execute the method
		
		// start time
		long begin = System.currentTimeMillis();
		
		
		
		// lets start executing the getFortune() Method
		Object result = null;
		
		try {
			myLogger.info("  \n====> @Around Prior to excuting on Method: "+tmpMethosig);
			result = tmpProceedingJP.proceed();
		} catch (Exception e) {
			//log the exception
			myLogger.warning(e.getMessage());
			
			//give the user a custom message and handle the exception
			/*
			result = " \n ===> An exception occured! Application restored with defaults ";
			*/
			
			/*
			 * Other option is to throw the exception to the calling program
			 * 
			 */
			throw e;
			
		}
		myLogger.info("  \n====> @Around POST excuting on Method: "+tmpMethosig);
		
		// end item
		long end = System.currentTimeMillis();
		
		//calculate the duration taken to execute
		long duration = end - begin;
		
		myLogger.info(" \n===> Duration to execute method: "+duration/1000.0+"seconds\n");
		//return the time taken to execute the method
		
		return result;
	}
	
	
	
}
