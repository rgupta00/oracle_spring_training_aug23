package com.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;

//REST end points
@RestController
@RequestMapping(path = "accounts")
public class AccountCrudController {
	
	private AccountService accountService;

	@Autowired
	public AccountCrudController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	//============getting all accounts==========
	@GetMapping
	public List<Account> getAllAccounts(){
		return accountService.getAll();
	}
	
	//============getting an account by id==========
	@GetMapping(path = "{id}")
	public Account getAccountById(@PathVariable(name="id")int id){
		return accountService.getById(id);
	}
	
	//===========adding a new account==========
	@PostMapping
	public String addAccount(@RequestBody  Account account) {
		accountService.addAccount(account);
		return "Accunt added sucessfully with id :"+account.getId();
	}
	
	//============updating the email or phone==========
	@PutMapping(path = "{id}")
	public String updateAccount(@PathVariable(name="id")  int id, @RequestBody   Account account) {
		accountService.updateAccount(id, account);
		return "Accunt updated sucessfully with id :"+account.getId();
	}
	
	//============delete an account==========
	
	@DeleteMapping(path = "{id}")
	public String deleteAccount(@PathVariable(name="id")  int id) {
		accountService.deleteAccount(id);
		return "Accunt deleted sucessfully with id :"+id;
	}
	
}





