package com.setu.expensetracker.dto;

import java.util.List;

public class GroupResponseDto {

	Integer groupId;
	String name;
	List<Integer> users;

	public GroupResponseDto(Integer groupId, String name, List<Integer> users) {
		super();
		this.groupId = groupId;
		this.name = name;
		this.users = users;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getUsers() {
		return users;
	}

	public void setUsers(List<Integer> users) {
		this.users = users;
	}

}
