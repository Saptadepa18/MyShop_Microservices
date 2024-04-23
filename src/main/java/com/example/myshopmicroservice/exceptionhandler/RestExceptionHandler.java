package com.example.myshopmicroservice.exceptionhandler;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.example.myshopmicroservice.exception.NoProductFoundException;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@RestController
@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(value=NoProductFoundException.class)
	public ResponseEntity<ApiError> handleNoProductException()
	{
		ApiError err=new ApiError("Product Microservice:"+400,"No Product Found",new Date());
		return new ResponseEntity<ApiError>(err,HttpStatus.BAD_REQUEST);
	}

}
