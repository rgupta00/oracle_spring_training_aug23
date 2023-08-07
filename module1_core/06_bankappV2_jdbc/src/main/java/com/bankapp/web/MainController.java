package com.bankapp.web;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bankapp.config.AppConfig;
import com.bankapp.dao.Account;
import com.bankapp.service.AccountService;

public class MainController {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		AccountService accountService = ctx.getBean("as", AccountService.class);

		List<Account> getAllAccounts = accountService.getAll();

		for (Account account : getAllAccounts) {
			System.out.println(account);
		}

	
	}

}
