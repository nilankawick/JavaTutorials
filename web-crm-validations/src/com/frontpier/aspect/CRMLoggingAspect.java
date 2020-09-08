package com.frontpier.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	//setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	
	
	//pointcut declaration
	@Pointcut("execution(* com.frontpier.controller.*.*(..))")
	private void pointcutForController() {
		
	}
	
	@Pointcut("execution(* com.frontpier.service.*.*(..))")
	private void pointcutForService() {
		
	}
	
	@Pointcut("execution(* com.frontpier.dao.*.*(..))")
	private void pointcutForDao() {
		
	}
	
	@Pointcut("pointcutForController() || pointcutForService() || pointcutForDao()")
	private void forAppFlow() {
		
	}
	
	//add @before advice
	@Before("forAppFlow()")
	private void before(JoinPoint tmpJointPoint) {
		
		//display the method we are calling 
		MethodSignature methoSig = (MethodSignature) tmpJointPoint.getSignature();
		
		String method = tmpJointPoint.getSignature().toShortString();
		myLogger.info("===> in @Before: Calling Method: " + methoSig);
		
		//display the arguments
		Object[] args = tmpJointPoint.getArgs();
		
		//loop through the arugments 
		
		for(Object tmpArgs : args) {
			myLogger.info("		===> in @Before: Calling Method Arguments: " + tmpArgs);
		}
	}
	
	//add @AfterReturning advice
	@AfterReturning(pointcut="forAppFlow()",
			returning="theResult")
	private void after(JoinPoint tmpJointPoint, Object theResult) {
		
		//display the method we are returning from
		MethodSignature methoSig = (MethodSignature) tmpJointPoint.getSignature();
		
		String method = tmpJointPoint.getSignature().toShortString();
		myLogger.info("===> in @AfterReturning: from Method: " + methoSig);
		
		//display the data returned
		myLogger.info("===> returned result: "+theResult);
		
		
	}
	
	
	

}
