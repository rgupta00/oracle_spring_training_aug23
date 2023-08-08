package com.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.TransferDto;
import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;

//REST end points
@RestController
public class AccountController {
	
	private AccountService accountService;

	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	//give all the accounts
	@GetMapping(path = "accounts")
	public List<Account> getAllAccounts(){
		return accountService.getAll();
	}
	
	//get an specfic account
	@GetMapping(path = "accounts/{id}")
	public Account getAccountById(@PathVariable(name="id")int id){
		return accountService.getById(id);
	}
	
	//rest end point for fund transfer 
	
	@PostMapping(path="accounts")
	public String addAccount(@RequestBody TransferDto transferDto) {
		accountService.transfer(transferDto.getFromAccount(), transferDto.getToAccount(),
				transferDto.getAmount());
		return "fund is transfered successfully";
	}

}





