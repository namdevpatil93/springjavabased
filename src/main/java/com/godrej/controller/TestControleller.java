package com.godrej.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.godrej.dto.UserDto;
import com.godrej.service.TestService;

@RestController
public class TestControleller {

	@Autowired
	private TestService testService;
	
	@RequestMapping(value="/index")
	public void index()
	{
		
	}
	
	@RequestMapping(value="/")
	public ModelAndView In()
	{
		System.out.println("in /");
	
		return new ModelAndView("index");
	}
	@PostMapping(value="/adduser",consumes ="application/json",produces="application/json")
	public UserDto addUser(@RequestBody UserDto user)
	{
		UserDto u=new UserDto();
		u.setName("namdev success");
		return u;
	}
	
	
	
	@GetMapping(value="/get",produces="text/plain")
	@ResponseBody
	public String get()
	{
		return testService.getFromBean();
	}
}
