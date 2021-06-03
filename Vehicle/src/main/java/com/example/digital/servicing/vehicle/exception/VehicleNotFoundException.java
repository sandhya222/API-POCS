package com.example.digital.servicing.vehicle.exception;

public class VehicleNotFoundException extends Exception{
	
	
	private String errorCode;
	private String applicationName;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public VehicleNotFoundException(String errorMessage) {
		super(errorMessage);
	}
	
	
	public VehicleNotFoundException(String errorCode,String applicationName,String errorMessage) {
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
