package com.setu.expensetracker.dto;

public class UserResponseDto {

	private int id;
	private String username;
	private String fullName;
	private Integer age;

	public UserResponseDto(int id, String username, String fullName, Integer age) {
		super();
		this.id = id;
		this.username = username;
		this.fullName = fullName;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
