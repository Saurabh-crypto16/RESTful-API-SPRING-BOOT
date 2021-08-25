package com.springboot.first.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//custom exception if resource is not found in database

@ResponseStatus(value=HttpStatus.NOT_FOUND)	//whenever REST API will not find resource it will throw NOT_FOUND status
public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String fieldName;
	private Object fieldValue;
	
	//constructor with custom message for super class
	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	//getters
	public String getFieldName() {
		return fieldName;
	}
	
	public String getResourceName() {
		return resourceName;
	}
	
	public Object getFieldValue() {
		return fieldValue;
	}
}
