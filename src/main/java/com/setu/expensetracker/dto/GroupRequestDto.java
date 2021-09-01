package com.setu.expensetracker.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class GroupRequestDto {

	@NotBlank
	String name;

	@NotNull
	List<Integer> userIds;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<Integer> userIds) {
		this.userIds = userIds;
	}

}
