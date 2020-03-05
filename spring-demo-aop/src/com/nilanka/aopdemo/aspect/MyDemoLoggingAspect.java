package com.nilanka.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//before advice
	
	/*
	 * Example of running before advise on a 
	 * - specific class ONLY, in this example (com.nilanka.aopdemo)
	 * - on a specific method --> addAccount
	 * - on a method with return type void
	 * - access modifier is public
	 * - no args as parameters 
	 */
	/*
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n ====> Executing @Before ADVICE on Method addAccount() ");
	}
	*/
	
	
	/*
	 * Example of running before advise on a 
	 * - specific class ONLY, in this example (com.nilanka.aopdemo.dao.AccountDAO)
	 * - on a specific method --> addAccount
	 * - on a method with return type void
	 * - access modifier is public
	 * - no args as parameters 
	 */
	/*
	@Before("execution(public void com.nilanka.aopdemo.dao.AccountDAO.addAccount())")
	public void beforeAddAccountAdvice(){
		System.out.println("\n ====> Executing @Before ADVICE on Method AccountDAO.addAccount() ");
	}
	*/
	
	/*
	 * Example of running before advise 
	 *  - on a any class, 
	 *  - that has a access modifier of Public, 
	 *  - that contains a method  that start with 'add'* 
	 *  - and a return type void
	 *  - and is no params as arguments for the method
	 * this is an example of using wild cards
	 */
	/*
	@Before("execution(public void add*())")
	public void beforeAnyAddAccountAdvice(){
		System.out.println("\n ====> Executing @Before ADVICE on any Method that start with add*(example of using wild cards) ");
	}
	*/
	
	
	/*
	 * Example of matching on a class that 
	 *  - has a specific return type (in this example void) 
	 *  - and a method name that starts with "add"
	 *  - and is no params as arguments for the method
	 *do note that the modifier (public/private) is optional when defining an pointcut expression
	 */
	/*
	@Before("execution(void add*())")
	public void beforeVoidAddAccountAdvice(){
		System.out.println("\n ====> Executing @Before ADVICE on any Method with return type void");
	}
	*/
	
	/*
	 * Example of matching on 
	 * - any access modifier (public or private)
	 * - any return type 
	 * - that has a method name that starts with add(using a wild card)
	 * - and has no args as parameters
	 *
	 */
	/*
	@Before("execution(* add*())")
	public void beforeVoidAddAccountAdvice(){
		System.out.println("\n ====> Executing @Before ADVICE on any Method with return type void");
	}
	*/
	
	
	
	/*
	 * Example of matching on 
	 * - that has a access modifier of Public or private
	 * - any return type 
	 * - any class that has a method name that starts with add(using a wild card 'add*')
	 * - and has a method signature/pass in parameter/method argument that is a "Account Class" that part of the "com.nilanka.aopdemo" package
	 *
	 */
	/*
	@Before("execution(* add*(com.nilanka.aopdemo.Account))")
	public void beforeVoidAddAccountAdvice(){
		System.out.println("\n ====> Executing @Before ADVICE on any method call with \n -that has a access modifier of Public or private"
				+ "\n -any return type \n -any class that has a method name that starts with add(using a wild card 'add*')"
				+ "\n -and has a method signature/pass in parameter/method argument"
				+ "\n   - that id part of the 'com.nilanka.aopdemo' package"
				+ "\n ====>");
	}
	*/
	
	
	
	/*
	 * Example of matching on 
	 * - that has a access modifier of Public or private
	 * - any return type 
	 * - any class that has a method name that starts with add(using a wild card 'add*')
	 * - and has a method signature that has multiple pass in parameter/arguments
	 * --- that is a "Account Class" that part of the "com.nilanka.aopdemo" package
	 * --- and 
	 *
	 */
	/*
	@Before("execution(* add*(com.nilanka.aopdemo.Account,..))")
	public void beforeVoidAddAccountAdvice(){
		System.out.println("\n ====> Executing @Before ADVICE on any method call with \n -that has a access modifier of Public or private"
				+ "\n -any return type \n -any class that has a method name that starts with add(using a wild card 'add*')"
				+ "\n -and has a method signature that has multiple pass in parameter/arguments"
				+ "\n   - Account object that is part of the 'com.nilanka.aopdemo' package"
				+ "\n   - and any number of arguments"
				+ "\n ====>");
	}
	*/
	
	/*
	 * Example of matching on 
	 * - that has a access modifier of Public or private
	 * - any return type 
	 * - any class that has a method name that starts with add(using a wild card 'add*')
	 * - and has a method signature that has any parameters/arguments
	 *
	 */
	/*
	@Before("execution(* add*(..))")
	public void beforeVoidAddAccountAdvice(){
		System.out.println("\n ====> Executing @Before ADVICE on any method call with \n -that has a access modifier of Public or private"
				+ "\n -any return type \n -any class that has a method name that starts with add(using a wild card 'add*')"
				+ "\n -and has a method signature that has any parameters/arguments"
				+ "\n ====>");
	}
	*/
	
	/*
	 * Example of matching on 
	 * - that has a access modifier of Public or private
	 * - any return type
	 * - only on the 'package com.nilanka.aopdemo.dao'
	 * - any class '.*'
	 * - any method '.*'
	 * - and has a method signature that has any parameters/arguments
	 *
	 */
	
	/*
	@Before("execution(* com.nilanka.aopdemo.dao.*.*(..))")
	public void beforeVoidAddAccountAdvice(){
		System.out.println("\n ====> Executing @Before ADVICE on any method call with \n -that has a access modifier of Public or private"
				+ "\n -any return type \n -only on the 'package com.nilanka.aopdemo.dao'"
				+ "\n -on any class within that package"
				+ "\n -on any method"
				+ "\n    -that has a method signature that has any parameters/arguments"
				+ "\n ====>");
	}
	
	*/
	
	
	
	
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
	/**/
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
	
	/*
	@Pointcut("execution(* com.nilanka.aopdemo.dao.*.*(..))")
	private void forDAOPackage() {}
	*/
	
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
	
	/*
	@Pointcut("execution(* com.nilanka.aopdemo.dao.*.get*(..))")
	private void forDAOPackageGetter() {}
	*/
	
	
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
	/*
	@Pointcut("execution(* com.nilanka.aopdemo.dao.*.set*(..))")
	private void forDAOPackageSetter() {}
	*/
	
	
	
	//COMBINED POINT CUT THAT CUTS ACROSS//
	/*
	 * a. works on the package - com.nilanka.aopdemo.dao
	 * b. any class
	 * c. but not for methods starting with GET or SET
	 */
	
	/*
	@Pointcut("forDAOPackage() && !(forDAOPackageGetter() || forDAOPackageSetter())")
	private void forDAOPackageNoGetterSetter() {}
	*/
	
	/*
	@Before("forDAOPackageNoGetterSetter()")
	public void beforeVoidAddAccountAdvice(){
		System.out.println("  ====> Executing @Before advice on method  - [Performing beforeVoidAddAccountAdvice()]");
	}
	*/
	
	/*
	@Before("forDAOPackageNoGetterSetter()")
	public void performAPIAnalytics(){
		System.out.println("  ====> Executing @Before advice on method - [Performing performAPIAnalytics()]");
	}
	*/
	
}
