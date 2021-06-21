package com.example.bank.payment.exception;

public class PayerNotFoundException extends  Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	private String applicationName;
	
	
	public PayerNotFoundException(String errorMessage) {
		super(errorMessage);
	}
	public PayerNotFoundException(String errorCode,String applicationName,String errorMessage) {
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
	





}
