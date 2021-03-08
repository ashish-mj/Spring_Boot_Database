package com.rakuten.controller;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rakuten.domain.APIError;
import com.rakuten.exceptions.ProductNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
//Global exception handler for whole Application ...
@RestControllerAdvice
public class ProductExceptionHandler {
	
@ExceptionHandler(ProductNotFoundException.class)
public ResponseEntity<APIError> handleException(Exception e) {
	System.out.println("exception caught..");
	APIError error=new APIError();
	error.setErrorMsg(e.getMessage());
	error.setStatus(HttpStatus.NOT_FOUND);
	 ResponseEntity<APIError> entity=new ResponseEntity<APIError>(error, HttpStatus.NOT_FOUND);
	return entity;
}
}
