package com.order.exception;

public class ProductNotFoundException extends RuntimeException{
	
	private String errorMessage;
	private String errorCode;
	
	public ProductNotFoundException(String errorMessage, String errorCode) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	
	

}
