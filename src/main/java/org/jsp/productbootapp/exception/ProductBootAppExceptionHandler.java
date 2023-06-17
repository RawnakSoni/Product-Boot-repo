package org.jsp.productbootapp.exception;

import org.jsp.productbootapp.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ProductBootAppExceptionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(ProductIdNotFoundFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleProductIdNotFoundException(ProductIdNotFoundFoundException e)
	{
		ResponseStructure<String> str = new ResponseStructure<String>();
		str.setBody("Product Not Found");
		str.setCode(HttpStatus.NOT_FOUND.value());
		str.setMessage(e.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(str,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<ResponseStructure<String>> handleInvalidCredentialException(InvalidCredentialsException e)
	{
		ResponseStructure<String> str = new ResponseStructure<String>();
		str.setBody("Invalid Product ID/Product Name");
		str.setCode(HttpStatus.NOT_FOUND.value());
		str.setMessage(e.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(str,HttpStatus.NOT_FOUND);
	}
}
