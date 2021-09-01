package com.setu.expensetracker.dto;

public class GenericResponseDto {

	private String message;

	public GenericResponseDto(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
