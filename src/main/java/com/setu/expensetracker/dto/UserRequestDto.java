package com.setu.expensetracker.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class UserRequestDto {

	@NotBlank
	String username;

	@NotBlank
	String fullName;

	@NotNull
	Integer age;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
