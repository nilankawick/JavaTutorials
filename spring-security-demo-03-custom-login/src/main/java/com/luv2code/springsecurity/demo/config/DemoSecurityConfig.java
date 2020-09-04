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
			.withUser(users.username("john").password("123").roles("EMPLOYESS"))
			.withUser(users.username("Lasen").password("111").roles("MANAGER"))
			.withUser(users.username("Nilanka").password("222").roles("ADMIN"));
		
		
		
		
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
		
		http.authorizeRequests()
				.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/enforceLogin")
				.loginProcessingUrl("/authenticateUser")
				.permitAll();
				
		
		
	}

	
	
	
}
