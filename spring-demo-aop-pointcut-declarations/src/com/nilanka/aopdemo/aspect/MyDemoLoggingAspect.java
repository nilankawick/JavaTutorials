package com.nilanka.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	
	
	// POINT CUT EXPRESSION DECLARATION KEPT SEPERATELY //
	
	
	
	/* the below declaration is an example of 
	 * Matching on 
	 * - that has a access modifier of Public or private (any modifier)
	 * - any return type
	 * - only on the 'package com.nilanka.aopdemo.dao'
	 * - any class '.*'
	 * - any method '.*'
	 * - and has a method signature that has any parameters/arguments (..)
	 *
	 */
	/*
	@Pointcut("execution(* com.nilanka.aopdemo.dao.*.*(..))")
	private void forDAOPackage() {}
	
	@Before("forDAOPackage()")
	public void beforeVoidAddAccountAdvice(){
		System.out.println("\n ====> Example of using the same pointcut declaration"
				+ "\n    -beforeVoidAddAccountAdvice()"
				+ "\n ====>");
	}
	
	@Before("forDAOPackage()")
	public void performAPIAnalytics(){
		System.out.println("\n ====> Example of using the same pointcut declaration"
				+ "\n    -performAPIAnalytics()"
				+ "\n ====>");
	}
	*/
	
	
	
	//COMBINING POINTCUT EXPRESSIONS //
	
	
	
	/* the below declaration is an example of 
	 * Matching on 
	 * - that has a access modifier of Public or private (any modifier)
	 * - any return type
	 * - only on the 'package com.nilanka.aopdemo.dao'
	 * - any class '.*'
	 * - any method '.*'
	 * - and has a method signature that has any parameters/arguments (..)
	 *
	 */
	
	/**/
	@Pointcut("execution(* com.nilanka.aopdemo.dao.*.*(..))")
	private void forDAOPackage() {}
	
	
	/* the below declaration is an example of 
	 * Matching on 
	 * - that has a access modifier of Public or private (any modifier)
	 * - any return type
	 * - only on the 'package com.nilanka.aopdemo.dao'
	 * - any class '.*'
	 * - any method that starts with '.get*'
	 * - and has a method signature that has any parameters/arguments (..)
	 *
	 */
	
	/* */
	@Pointcut("execution(* com.nilanka.aopdemo.dao.*.get*(..))")
	private void forDAOPackageGetter() {}
	
	
	
	/* the below declaration is an example of 
	 * Matching on 
	 * - that has a access modifier of Public or private (any modifier)
	 * - any return type
	 * - only on the 'package com.nilanka.aopdemo.dao'
	 * - any class '.*'
	 * - any method that starts with '.set*'
	 * - and has a method signature that has any parameters/arguments (..)
	 *
	 */
	
	 
	/**/
	@Pointcut("execution(* com.nilanka.aopdemo.dao.*.set*(..))")
	private void forDAOPackageSetter() {}
	
	
	
	
	//COMBINED POINT CUT THAT CUTS ACROSS//
	/*
	 * a. works on the package - com.nilanka.aopdemo.dao
	 * b. any class
	 * c. but not for methods starting with GET or SET
	 */
	
	/**/
	@Pointcut("forDAOPackage() && !(forDAOPackageGetter() || forDAOPackageSetter())")
	private void forDAOPackageNoGetterSetter() {}
	
	
	/**/
	@Before("forDAOPackageNoGetterSetter()")
	public void beforeVoidAddAccountAdvice(){
		System.out.println(" \n ====> Executing @Before advice on method  - [Performing beforeVoidAddAccountAdvice()]");
	}
	
	
	/**/
	@Before("forDAOPackageNoGetterSetter()")
	public void performAPIAnalytics(){
		System.out.println("  ====> Executing @Before advice on method - [Performing performAPIAnalytics()]");
	}
	
	
}
