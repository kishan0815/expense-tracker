package com.setu.expensetracker.dto;

import java.util.List;

public class BalanceResponseDto {

	Integer userId;
	List<UserShareDto> balances;
	Float netAmount;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<UserShareDto> getBalances() {
		return balances;
	}

	public void setBalances(List<UserShareDto> balances) {
		this.balances = balances;
	}

	public Float getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(Float netAmount) {
		this.netAmount = netAmount;
	}

}
