package com.example.digital.servicing.vehicle.exception;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class VehicleExceptionHandler extends ResponseEntityExceptionHandler {
	
	
    @ExceptionHandler(value 
    	      = { IllegalArgumentException.class, IllegalStateException.class })
    	    protected ResponseEntity<Object> handleConflict(
    	      RuntimeException ex, WebRequest request) {
    	        String bodyOfResponse = "invalid request in vehicle request params";
    	        return handleExceptionInternal(ex, bodyOfResponse, 
    	          new HttpHeaders(), HttpStatus.CONFLICT, request);
    	    }

    
    @ExceptionHandler(value 
  	      = { VehicleNotFoundException.class })
  	    protected ResponseEntity<Object> handleVehicleNotFoundException(
  	    		VehicleNotFoundException ex, WebRequest request) {
  	        String bodyOfResponse = "vehicle record not found";
  	        return handleExceptionInternal(ex, bodyOfResponse, 
  	          new HttpHeaders(), HttpStatus.NOT_FOUND, request);
  	    }

    
    @ExceptionHandler(value 
    	      = { Exception.class })
    	    protected ResponseEntity<Object> handleDefaultException(
    	      RuntimeException ex, WebRequest request) {
    	        String bodyOfResponse = "runtime error occured";
    	        return handleExceptionInternal(ex, bodyOfResponse, 
    	          new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    	    }


	
	

}
