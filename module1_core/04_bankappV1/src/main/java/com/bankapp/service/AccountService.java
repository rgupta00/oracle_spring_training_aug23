package com.bankapp.service;

import java.util.List;

import com.bankapp.dao.Account;

public interface AccountService {
	
	public List<Account> getAll();


	public Account getById(int id);

	public void deposit(int accId, double amount);
	
	public void withdraw(int accId, double amount);
	
	public void transfer(int fromAcc, int toAcc, double amount);
}











