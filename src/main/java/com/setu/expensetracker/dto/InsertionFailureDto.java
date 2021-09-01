package com.setu.expensetracker.dto;

public class InsertionFailureDto {

	private String status;
	private String reason;
	
	public InsertionFailureDto() {
		super();
	}

	public InsertionFailureDto(String status, String reason) {
		super();
		this.status = status;
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
