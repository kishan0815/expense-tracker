package com.setu.expensetracker.dto;

import javax.validation.constraints.NotNull;

public class ResolveExpenseDto {

	@NotNull
	Integer userId;
	
	@NotNull
	Integer expenseId;
	
	@NotNull
	Float amount;
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(Integer expenseId) {
		this.expenseId = expenseId;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

}
