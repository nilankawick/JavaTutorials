package com.nilanka.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAopExpressions {

	
	
	//COMBINING POINTCUT EXPRESSIONS & POINTCUTS KEPT SEPERATELY SO THAT IT CAN BE SHARED//
	
	
	
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
	public void forDAOPackage() {}
	
	

	@Pointcut("execution(* com.nilanka.aopdemo.dao.*.get*(..))")
	public void forDAOPackageGetter() {}
	
	

	@Pointcut("execution(* com.nilanka.aopdemo.dao.*.set*(..))")
	public void forDAOPackageSetter() {}
	
	
	
	
	//COMBINED POINT CUT THAT CUTS ACROSS//
	/*
	 * a. works on the package - com.nilanka.aopdemo.dao
	 * b. any class
	 * c. but not for methods starting with GET or SET
	 */
	
	/**/
	@Pointcut("forDAOPackage() && !(forDAOPackageGetter() || forDAOPackageSetter())")
	public void forDAOPackageNoGetterSetter() {}
	
	
	@Pointcut("forDAOPackageGetter() || forDAOPackageSetter()")
	public void forDAOPackageOnlyGetterSetter() {}
	
}
