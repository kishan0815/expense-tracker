package com.setu.expensetracker.dto;

import javax.validation.constraints.NotNull;

public class UserShareDto {

	@NotNull
	Integer userId;

	@NotNull
	Float amount;

	public UserShareDto() {
		super();
	}

	public UserShareDto(@NotNull Integer userId, @NotNull Float amount) {
		super();
		this.userId = userId;
		this.amount = amount;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

}
