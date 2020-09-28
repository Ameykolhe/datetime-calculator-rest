package com.ameykolhe.datetime.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ameykolhe.datetime.entities.ErrorResponse;
import com.ameykolhe.datetime.exceptions.InvalidParameterException;

@ControllerAdvice
public class DateTimeCalculatorRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleInvalidParameterException(InvalidParameterException exc) {
		
		// create CustomerErrorResponse
		ErrorResponse error = new ErrorResponse(
											HttpStatus.BAD_REQUEST.value(),
											exc.getMessage());
		
		// return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception exc) {
		// create CustomerErrorResponse	
		ErrorResponse error = new ErrorResponse(
											HttpStatus.INTERNAL_SERVER_ERROR.value(),
											exc.getMessage());
		
		// return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
