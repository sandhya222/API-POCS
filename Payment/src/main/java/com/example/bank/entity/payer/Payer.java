package com.example.bank.entity.payer;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="people")
public class Payer implements  Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long payerId;
	
	@Column
	public String payerName;
	
	@Column
	public String address;
	
	@Column
	public Boolean payerStatus;
	
	
	public Long getPayerId() {
		return payerId;
	}
	public void setPayerId(Long payerId) {
		this.payerId = payerId;
	}
	public String getPayerName() {
		return payerName;
	}
	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Boolean getPayerStatus() {
		return payerStatus;
	}
	public void setPayerStatus(Boolean payerStatus) {
		this.payerStatus = payerStatus;
	}
	
	
	public Payer() {
		super();
		
	}
	

}
