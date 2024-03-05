package com.jwt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {

	@ExceptionHandler
	public ResponseEntity handleAccessDeniedException(AccessDeniedException e){

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());


	}

	@ExceptionHandler
	public ResponseEntity handleUserNotFoundException(UserNotFound e){

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());


	}
	/*
	 * @ExceptionHandler public ResponseEntity handleException(Exception e){
	 * 
	 * return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
	 * body("Some thing went wrong.............");
	 * 
	 * 
	 * }
	 */



}
