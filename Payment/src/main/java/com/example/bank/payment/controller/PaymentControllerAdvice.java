package com.example.bank.payment.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice(assignableTypes = PaymentController.class)
@RequestMapping(produces = "application/vnd.error+json")
public class PaymentControllerAdvice extends ResponseEntityExceptionHandler {
	
	
	
	  @ExceptionHandler(PaymentNotFoundException.class)
	  public ResponseEntity<Error> notFoundException(PaymentNotFoundException e) {
	    return error(e, HttpStatus.NOT_FOUND, e.getId().toString());
	  }

	private ResponseEntity<Error> error(PaymentNotFoundException e, HttpStatus notFound, String string) {
		// TODO Auto-generated method stub
		return null;
	}

	/*(@ExceptionHandler(PayerNotFoundException.class)
	  public ResponseEntity<Error> notFoundException(final PayerNotFoundException e1) {
	    return error(e1, HttpStatus.NOT_FOUND, e1.getId().toString());
	  }

	private ResponseEntity<Error> errorCode(PaymentNotFoundException e, HttpStatus notFound, String string) {
		// TODO Auto-generated method stub
		return null;
	})*/

	
	
	
	//@Exception
	//PayerNotFound method
	//PaymentNotFound method

}
