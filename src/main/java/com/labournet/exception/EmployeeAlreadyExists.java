package com.labournet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyExists extends RuntimeException {
	
	 private String message;

	public EmployeeAlreadyExists(String message) {
		super(message);
	}
	 
	 

}
