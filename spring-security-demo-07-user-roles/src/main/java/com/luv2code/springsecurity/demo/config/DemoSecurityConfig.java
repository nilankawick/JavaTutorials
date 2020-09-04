package com.luv2code.springsecurity.demo.config;

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

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// in memory authentication
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("john").password("123").roles("EMPLOYEE"))
			.withUser(users.username("Lasen").password("111").roles("EMPLOYEE","MANAGER"))
			.withUser(users.username("Nilanka").password("222").roles("EMPLOYEE","ADMIN"));
		
		
		
		
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
		
		/*
		 
		http.authorizeRequests()
				.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/enforceLogin")
				.loginProcessingUrl("/authenticateUser")
				.permitAll()
			.and()
			.logout().permitAll();
		* 
		 */
		
		/*
		 * Restricting access based on role
		 */
		http.authorizeRequests()
				.antMatchers("/").hasRole("EMPLOYEE")
				.antMatchers("/leaders/**").hasRole("MANAGER")
				.antMatchers("/admin/**").hasRole("ADMIN")
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
