package com.godrej.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.godrej.service.TestService;
import com.godrej.service.TestServiceImpl;
 
@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"com.godrej.*"})
public class AppConfig implements WebMvcConfigurer{

	@Bean
	public ViewResolver viewResolver()
	{
		System.out.println("in viewresolver");
		InternalResourceViewResolver d=new InternalResourceViewResolver();
		d.setPrefix("/WEB-INF/views/");
		d.setSuffix(".jsp");
		return d;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Bean
	public TestService testService()
	{
		
		TestServiceImpl testservice=new TestServiceImpl();
		testservice.hello="hello1111111111111";
		return testservice;
	}
   
}
