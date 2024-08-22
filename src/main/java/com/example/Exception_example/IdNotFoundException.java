package com.example.Exception_example;

public class IdNotFoundException extends RuntimeException{

	String message;

	public IdNotFoundException(String message) {
		super(message);
		this.message = message;
	}
	
}
