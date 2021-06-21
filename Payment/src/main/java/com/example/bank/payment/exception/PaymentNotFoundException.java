package com.example.bank.payment.exception;


public class PaymentNotFoundException extends Exception  {
	
	
	private String errorCode;
	private String applicationName;
	
	private static final long serialVersionUID = 1L;
	
	public PaymentNotFoundException(String errorMessage) {
		super(errorMessage);
	}
	public PaymentNotFoundException(String errorCode,String applicationName,String errorMessage) {
		super(errorMessage);
		this.setApplicationName(applicationName);
		this.setErrorCode(errorCode);
	}

	
	
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}
	



}
