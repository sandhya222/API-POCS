package com.example.bank.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank.entity.payment.Payment;

@Repository
@RestController
public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
	
	Payment findByPaymentId(Long paymentId);
	

	 
    //List<Payer> findByStatus(Boolean payerStatus);
    

    
    
    
 
	

}
