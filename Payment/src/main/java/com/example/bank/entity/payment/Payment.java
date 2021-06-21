package com.example.bank.entity.payment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Payment implements java.io.Serializable{
	
	
	private static final long serialVersionUID = 1L;

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long paymentId;
	
	@Column
	private String paymentAmount;
	//email,
	
	@Column
	private String paymentDate;
	
	@Column
	private String payerId;

	public Long getAccountId() {
		return paymentId;
	}

	public void setAccountId(Long accountId) {
		this.paymentId = accountId;
	}

	public String getAmount() {
		return paymentAmount;
	}

	public void setAmount(String amount) {
		this.paymentAmount = amount;
	}

		public String getRefundAmount() {
		return paymentDate;
	}

	public void setRefundAmount(String refundAmount) {
		this.paymentDate = refundAmount;
	}

		public Payment() {
		super();
	}

		public String getStatus() {
			return payerId;
		}

		public void setStatus(String status) {
			this.payerId = status;
		}
	
}
	
	