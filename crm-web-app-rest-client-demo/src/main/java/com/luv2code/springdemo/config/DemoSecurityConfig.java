package com.luv2code.springdemo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
	
	//reference to the security datasource
	@Autowired
	private DataSource securityDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		// The commented out code block is used for in memory authentication
				/*
				UserBuilder users = User.withDefaultPasswordEncoder();
				
				
				auth.inMemoryAuthentication()
					.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
					.withUser(users.username("mary").password("test123").roles("EMPLOYEE", "MANAGER"))
					.withUser(users.username("susan").password("test123").roles("EMPLOYEE", "ADMIN"));
				*/
		
		//using JDBC Authentication
		
		auth.jdbcAuthentication().dataSource(securityDataSource);
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		/*
		 * The following code block enforces the following 
		 * authenticate any request
		 * and 
		 * use  a login form
		 * where the login form 
		 * and login processing page
		 * and permit all authentication requests to this 
		 */
		System.out.println("JDBC base authorisation");
		http.authorizeRequests()
				//.anyRequest().authenticated() //not required if you are using role base access
				.antMatchers("/").hasRole("EMPLOYEE")
				.antMatchers("/customer/delete").hasAnyRole("MANAGER","ADMIN")
				.antMatchers("/customer/showFormForUpdate").hasAnyRole("MANAGER","ADMIN")
				.antMatchers("/customer/saveCustomer").hasAnyRole("MANAGER","ADMIN")
				.antMatchers("/customer/showFormForAdd").hasAnyRole("MANAGER","ADMIN")
			.and()
			.formLogin()
				.loginPage("/enforceLogin")
				.loginProcessingUrl("/authenticateUser")
				.permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");

		
		
		
	}
	
	
	

}
