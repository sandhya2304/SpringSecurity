package com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Employee implements Serializable
{
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String lastName;
	
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private Date dateBirth;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, String lastName, Date dateBirth) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.dateBirth = dateBirth;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}
	
	
	
	
	

}
