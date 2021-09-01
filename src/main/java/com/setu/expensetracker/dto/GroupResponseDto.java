package com.setu.expensetracker.dto;

import java.util.List;

public class GroupResponseDto {

	Integer groupId;
	String name;
	List<UserResponseDto> users;

	public GroupResponseDto(Integer groupId, String name, List<UserResponseDto> users) {
		super();
		this.groupId = groupId;
		this.name = name;
		this.users = users;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserResponseDto> getUsers() {
		return users;
	}

	public void setUsers(List<UserResponseDto> users) {
		this.users = users;
	}

}
