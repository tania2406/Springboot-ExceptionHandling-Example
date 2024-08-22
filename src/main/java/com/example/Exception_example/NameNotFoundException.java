package com.example.Exception_example;

public class NameNotFoundException extends RuntimeException
{
	String message;
	public NameNotFoundException(String message)
			{
		super(message);
		this.message=message;
			}

}
