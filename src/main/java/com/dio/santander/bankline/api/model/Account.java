package com.dio.santander.bankline.api.model;

import javax.persistence.Embeddable;

@Embeddable
public class Account {
	private Long number;
	private Double balance;

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	} 
	
}
