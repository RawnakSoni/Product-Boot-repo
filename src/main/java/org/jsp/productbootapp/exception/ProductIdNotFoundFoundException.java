package org.jsp.productbootapp.exception;

public class ProductIdNotFoundFoundException extends RuntimeException
{	
	@Override
	public String getMessage() 
	{
		return "Invalid ID";
	}
}
