package com.luv2code.springdemo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan("com.luv2code.springdemo")
@PropertySource({ "classpath:application.properties" })
public class DemoAppConfig implements WebMvcConfigurer {

	// setup a variable to hold and access env properties, defined in the properties file
	@Autowired
	private Environment env;
	
	
	//setup a logger for diagnostics
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	// define a bean for ViewResolver

	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	// define bean for RestTemplate ... this is used to make client REST calls
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	// add resource handler for loading css, images, etc
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/resources/**")
          .addResourceLocations("/resources/"); 
    }	
    
    
    
    
    /*
     * Security related DB setup
     */
    
    
  //Setting up a bean for our security datasource
  	@Bean
  	public DataSource securityDataSource() {
  				
  		//create connection pool
  		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
  		
  		//set the JDBC driver class
  		try {
  			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
  		} catch (PropertyVetoException exc) {
  			System.out.println("JDBC Exception ");	
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









