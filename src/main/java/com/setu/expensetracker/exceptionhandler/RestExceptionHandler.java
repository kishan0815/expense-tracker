package com.setu.expensetracker.exceptionhandler;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.setu.expensetracker.dto.InsertionFailureDto;
import com.setu.expensetracker.exception.InsertionException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	private static final String FAILURE = "failure";

	/**
	 * Handle javax.persistence.EntityNotFoundException
	 */
	@ExceptionHandler(value = { EntityNotFoundException.class })
	protected ResponseEntity<Object> handleEntityNotFound(final EntityNotFoundException ex, final WebRequest request) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * Handle HttpMessageNotReadableException. Happens when request JSON is
	 * malformed.
	 *
	 * @param ex      HttpMessageNotReadableException
	 * @param headers HttpHeaders
	 * @param status  HttpStatus
	 * @param request WebRequest
	 * @return the Error object
	 */
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException ex,
			final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
		return new ResponseEntity<>(new InsertionFailureDto(FAILURE, ex.getMessage()), HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handle MethodArgumentNotValidException. Triggered when an object fails @Valid
	 * validation.
	 *
	 * @param ex      the MethodArgumentNotValidException that is thrown when @Valid
	 *                validation fails
	 * @param headers HttpHeaders
	 * @param status  HttpStatus
	 * @param request WebRequest
	 * @return the ApiError object
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex,
			final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
		return new ResponseEntity<>(new InsertionFailureDto(FAILURE, ex.getMessage()), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
		return new ResponseEntity<>(new InsertionFailureDto(FAILURE, ex.getMessage()), HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handle custom InsertionException
	 */
	@ExceptionHandler(value = { InsertionException.class })
	protected ResponseEntity<Object> handleInsertionFailures(final InsertionException ex, final WebRequest request) {
		return new ResponseEntity<>(new InsertionFailureDto(FAILURE, ex.getMessage()), HttpStatus.BAD_REQUEST);
	}

}