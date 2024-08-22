package com.example.Exception_example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedExceptionHandling extends ResponseEntityExceptionHandler
{

	// Method 1: getting message from controller advice 
	
//	@ExceptionHandler(IdNotFoundException.class)
//	public ResponseEntity<Object> handleExceptions(IdNotFoundException exception)
//	{
//		ResponseEntity<Object> entity=new ResponseEntity<>("id not found", HttpStatus.NOT_FOUND);
//		return entity;
//	}
	// Method 2: 
	
	@ExceptionHandler(IdNotFoundException.class) // getting message from controller
	ResponseEntity<?> handleIdNotFoundException(IdNotFoundException ee){
		String message=ee.getMessage(); // GETTING MESSAGE FROM CONTROLLER CLASS.
		return new ResponseEntity<>(message,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	@ExceptionHandler(NameNotFoundException.class) // getting message from controller
	ResponseEntity<?> handleNameNotFoundException(NameNotFoundException ee){
		String message=ee.getMessage(); // GETTING MESSAGE FROM CONTROLLER CLASS.
		return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(CityNotFoundException.class) // getting message from controller
	ResponseEntity<?> handleCityNotFoundException(CityNotFoundException ee){
		String message=ee.getMessage(); // GETTING MESSAGE FROM CONTROLLER CLASS.
		return new ResponseEntity<>(message,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	}

