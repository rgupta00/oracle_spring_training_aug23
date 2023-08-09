package com.bankapp.dto;

public class DepositDto {
	
	private int accountId;
	private double amount;
	
	public DepositDto(int accountId, Double amount) {
		this.accountId = accountId;
		this.amount = amount;
	}

	public DepositDto() {}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	

}
