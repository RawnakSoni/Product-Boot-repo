package org.jsp.productbootapp.exception;

public class InvalidCredentialsException extends RuntimeException
{
	@Override
	public String getMessage() 
	{
		return "You might have entered Invalid ID/Product Name";
	}
}
