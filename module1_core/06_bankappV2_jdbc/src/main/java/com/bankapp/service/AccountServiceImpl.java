package com.bankapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.dao.Account;
import com.bankapp.dao.AccountDao;

// my service layer is loosely coupled from the dao layer :)
@Service(value = "as")
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
		return accountDao.getById(id);
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

	@Override
	public void addAccount(Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccount(int id) {
		// TODO Auto-generated method stub
		
	}
}







