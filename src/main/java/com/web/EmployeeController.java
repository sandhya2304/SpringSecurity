package com.web;

import org.springframework.web.bind.annotation.RequestMapping;

public class EmployeeController
{
	
	@RequestMapping(value="/login")
	public String login()
	{
		return "login";
	}
	

}
