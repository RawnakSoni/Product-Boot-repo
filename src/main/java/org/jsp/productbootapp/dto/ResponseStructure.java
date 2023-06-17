package org.jsp.productbootapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseStructure<T> 
{
	private String message;
	private T body;
	private int code;
}
