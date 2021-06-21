package com.example.bank.payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.entity.payment.Payment;
import com.example.bank.payment.exception.PaymentNotFoundException;
import com.example.bank.payment.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	// payment service==payer not found exception

	@Autowired
	private PaymentService paymentService;

	// call payer service

	public Payment findByPaymentId(Long paymentId) throws PaymentNotFoundException {

		Payment payment = paymentRepository.findByPaymentId(paymentId);
		
		if (payment == null) {
			throw new PaymentNotFoundException("no record found for accountId  : " + paymentId);
		}
		return payment;

	}

	public Payment findByStatus(Boolean paymentStatus) {

		// Payment accountNo = paymentRepository.findBy(accountNumber);
		return null;
	}

	public Payment savePayment(Payment payment) {
		return paymentRepository.save(payment);
	}

}
