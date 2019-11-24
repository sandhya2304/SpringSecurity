package com.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role implements Serializable
{
	@Id
	private String role;
	private String descirption;
	
	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Role(String role, String descirption) {
		super();
		this.role = role;
		this.descirption = descirption;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescirption() {
		return descirption;
	}

	public void setDescirption(String descirption) {
		this.descirption = descirption;
	}
	
	
	
	

}
