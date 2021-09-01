package com.setu.expensetracker.exception;

public class InsertionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InsertionException(String message) {
        super(message);
    }
}