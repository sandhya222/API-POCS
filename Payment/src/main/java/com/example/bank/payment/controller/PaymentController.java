package com.example.bank.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.bank.entity.payment.Payer;
import com.example.bank.entity.payment.Payment;
import com.example.bank.payment.exception.PaymentNotFoundException;
import com.example.bank.payment.service.PaymentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/v1/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private ObjectMapper objectMapper;

	// @Autowired
	private RestTemplate restTemplate;

	@GetMapping("/{payerId}")
	public ResponseEntity<Object> processPayment(@PathVariable("payerId") Long payerId)
			throws PaymentNotFoundException {

		String uri = "http://localhost:8096/digital/application/v1/payer/";
		uri=uri+payerId;
		

		restTemplate = new RestTemplate();
		
		Payer payerDetails = restTemplate.getForObject(uri, Payer.class);
		

		// IF result==null then ThrowPayerNotFoundException
		// IF result.payerStatus=False then ThrowPayerNotActiveException
		
		
		//Check if HTTP Status = 500 then return payee not found
		//Convert result into json object and check payerStatus value..
		
		if (payerDetails == null) {

			return new ResponseEntity<Object>(("Payer Not found"), new HttpHeaders(),
					HttpStatus.OK);
		}
		
		if (!payerDetails.payerStatus) {

			return new ResponseEntity<Object>(("Payer is not active"), new HttpHeaders(),
					HttpStatus.OK);
		}

		return new ResponseEntity<Object>(payerDetails, new HttpHeaders(), HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<String> insertPaymentDetails(@RequestBody Payment payment) throws JsonProcessingException {
		Payment paymentSaved = null;
		paymentSaved = paymentService.savePayment(payment);

		System.out.println("saved payment information : " + objectMapper.writeValueAsString(paymentSaved));
		return new ResponseEntity<String>("Record Saved Succesfully", new HttpHeaders(), HttpStatus.OK);

	}

}
