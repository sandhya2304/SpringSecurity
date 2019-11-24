package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dao.EmployeeRepository;
import com.entity.Employee;

@RestController
public class EmployeeService
{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Secured(value = {"ADMIN"})
	@RequestMapping(value="/saveEmployee",method = RequestMethod.POST)
	public Employee saveEmployee(Employee emp)
	{
		return employeeRepository.save(emp);
	}
	
	
	@Secured(value = {"ADMIN","STUDENT","PROF"})
	@RequestMapping(value="employees")
	public Page<Employee> listEmployee(int page,int size)
	{
		return employeeRepository.findAll(new PageRequest(page, size));
	}
	
	@RequestMapping(value="/getLoggedIn")
	public Map<String,Object> getLoggedUser(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		SecurityContext ctxt = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
		String username = ctxt.getAuthentication().getName();
		List<String> roles = new ArrayList<>();
		for(GrantedAuthority ga : ctxt.getAuthentication().getAuthorities())
		{
			roles.add(ga.getAuthority());
		}
		
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("username",username);
		params.put("roles",roles);
		
		return params;
	}
	
	
	
	

}
