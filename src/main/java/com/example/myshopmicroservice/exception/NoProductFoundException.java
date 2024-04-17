package com.example.myshopmicroservice.exception;

public class NoProductFoundException extends RuntimeException{
	
	public NoProductFoundException(String msg)
	{
		super(msg);
	}

}
