package com.luv2code.springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.luv2code.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
	
	//setup variable to hold DB properties
	/*
	 * The Enviornment type is a special helper class that 
	 * gives access to the mySQL properties that is defined as part of the 
	 * @PropertySource annotation
	 * the actual property file is available in src/main/resources
	 * this location is the default location for maven related properties
	 */
	@Autowired
	private Environment env;
	
	//setting up a logger to capture diagnostic related data
	private Logger logger = Logger.getLogger(getClass().getName());
	
	

	//define a bean for ViewResolver
	@Bean 
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver; 
		
	}
	
	
	//Setting up a bean for our security datasource
	@Bean
	public DataSource securityDataSource() {
				
		//create connection pool
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		
		//set the JDBC driver class
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			System.out.println("TEST ");	
			throw new RuntimeException(exc);
		}
		
		//log the connection  props
		logger.info(">>> jdbc.url=" +env.getProperty("jdbc.url"));
		logger.info(">>> jdbc.user=" +env.getProperty("jdbc.user"));
		
		
		//set db connection props
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		// set connection pool props
		securityDataSource.setInitialPoolSize(
				getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(
				getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(
				getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(
				getIntProperty("connection.pool.maxIdleTime"));
		
		return securityDataSource;
	}
	
	
	
	// need a helper method
	// read environment property and to convert it to int
	
	private int getIntProperty(String propval) {
		String tmpPropVal = env.getProperty(propval);
		int intPropVal = Integer.parseInt(tmpPropVal);
		return intPropVal;
		
	}
	
	
	
	
	
	
}
