package com.setu.expensetracker.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

public class ExpenseDto {

	@NotNull
	Integer groupId;

	@NotNull
	Float amount;
	
	@NotNull
	Integer paidUserId;
	
	@NotNull
	List<UserShareDto> userShare;

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Integer getPaidUserId() {
		return paidUserId;
	}

	public void setPaidUserId(Integer paidUserId) {
		this.paidUserId = paidUserId;
	}

	public List<UserShareDto> getUserShare() {
		return userShare;
	}

	public void setUserShare(List<UserShareDto> userShare) {
		this.userShare = userShare;
	}

}
