package com.bankapp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.DepositDto;
import com.bankapp.dto.TransferDto;
import com.bankapp.dto.WithdrawDto;
import com.bankapp.service.AccountService;

@RestController
@RequestMapping(path = "transactions")
public class TransactionController {

	private AccountService accountService;

	public TransactionController(AccountService accountService) {
		this.accountService = accountService;
	}

	//==========fund transfer =============
	@PostMapping(path = "transfer")
	public String transfer(@RequestBody TransferDto transferDto) {
		accountService.transfer(transferDto.getFromAccount(), transferDto.getToAccount(), transferDto.getAmount());
		return "fund is transfered successfully";
	}
	
	//==========fund deposit =============
	@PostMapping(path = "deposit")
	public String deposit(@RequestBody  DepositDto depositDto) {
		accountService.deposit(depositDto.getAccountId(), depositDto.getAmount());
		return "fund is deposit successfully";
	}
	
	
	//==========fund withdraw =============
	
	@PostMapping(path = "withdraw")
	public String withdraw(@RequestBody  WithdrawDto withdrawDto) {
		accountService.withdraw(withdrawDto.getAccountId(), withdrawDto.getAmount());
		return "fund is withdraw successfully";
	}

}







