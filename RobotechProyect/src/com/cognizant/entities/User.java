package com.cognizant.entities;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 2628588736339209456L;
	
	private int fieldId;
	private String name;
	private String password;
	
	public User() {
		
	}

	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public int getFieldId() {
		return fieldId;
	}

	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
