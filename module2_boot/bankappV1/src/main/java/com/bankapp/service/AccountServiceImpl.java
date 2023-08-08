package com.bankapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.entities.Account;
import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.repo.AccountDao;


@Service
public class AccountServiceImpl implements AccountService{
	
    private AccountDao accountDao;
	
	@Autowired
	public AccountServiceImpl(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public List<Account> getAll() {
		return accountDao.getAll();
	}


	@Override
	public Account getById(int id) {
		Account account= accountDao.getById(id);
		if(account==null)
			throw new BankAccountNotFoundException("account with id "+id +" is not found!");
		
		return account;
	}

	@Override
	public void deposit(int accId, double amount) {
		Account account=getById(accId);
		account.setBalance(account.getBalance()+amount);
		accountDao.updateAccount(account);
	}

	@Override
	public void withdraw(int accId, double amount) {
		Account account=getById(accId);
		account.setBalance(account.getBalance()-amount);
		accountDao.updateAccount(account);
	}

	@Override
	public void transfer(int fromAcc, int toAcc, double amount) {
		Account fromAccount=getById(fromAcc);
		Account toAccount=getById(toAcc);
		
		fromAccount.setBalance(fromAccount.getBalance()-amount);
		toAccount.setBalance(toAccount.getBalance()+amount);
		
		accountDao.updateAccount(fromAccount);
		accountDao.updateAccount(toAccount);
		
	}
}
