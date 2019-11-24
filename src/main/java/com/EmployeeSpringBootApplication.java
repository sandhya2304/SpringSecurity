package com;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.dao.EmployeeRepository;
import com.entity.Employee;

@SpringBootApplication
public class EmployeeSpringBootApplication
{
	public static void main(String[] args) throws ParseException
	{
		ApplicationContext cxt = SpringApplication.run(EmployeeSpringBootApplication.class, args);
		EmployeeRepository repo = (EmployeeRepository) cxt.getBean(EmployeeRepository.class);
		
		DateFormat date = new SimpleDateFormat("dd-mm-yyyy");
		
		repo.save(new Employee("ram","laxman", date.parse("23-04-2019")));
		repo.save(new Employee("sandhya","laxman", date.parse("3-04-2019")));
		repo.save(new Employee("harsh","laxman", date.parse("2-04-2019")));
		repo.save(new Employee("meera","laxman", date.parse("1-04-2019")));
		
		List<Employee> emp = repo.findAll();
		emp.forEach(s -> System.out.println(s.getName()));
		
	}

}
