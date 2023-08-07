package com.bankapp.web;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bankapp.config.AppConfig;
import com.bankapp.dao.Account;
import com.bankapp.service.AccountService;

public class MainController {

	public static void main(String[] args) {

		//you can choose spring profile 
		//without changing ur code
		
		//-Dspring.profiles.active=dev
		
		// annotation wala application context
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		AccountService accountService = ctx.getBean("as", AccountService.class);

		List<Account> getAllAccounts = accountService.getAll();

		for (Account account : getAllAccounts) {
			System.out.println(account);
		}

		accountService.transfer(1, 2, 10);
		System.out.println("--------------------------");
//		getAllAccounts = accountService.getAll();
//
//		for (Account account : getAllAccounts) {
//			System.out.println(account);
//		}
	}

}
