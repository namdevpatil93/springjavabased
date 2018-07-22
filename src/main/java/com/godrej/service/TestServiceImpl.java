package com.godrej.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.godrej.config.AppConfig;

@Service
public class TestServiceImpl implements TestService
{

	public String hello="";
	public String getFromBean() 
	{
		
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfig.class);
		applicationContext.refresh();
		
		TestServiceImpl t=(TestServiceImpl) applicationContext.getBean("testService");
		return t.hello;
	}

}
