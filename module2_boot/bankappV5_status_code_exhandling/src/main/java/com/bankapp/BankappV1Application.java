package com.bankapp;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;

@SpringBootApplication
public class BankappV1Application implements CommandLineRunner{

	@Autowired
	private AccountService accountService;
	
	public static void main(String[] args) {
		ApplicationContext ctx=  SpringApplication.run(BankappV1Application.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		//CommandlineRunner have one method run... it will run just after spring boot started
		//String name, double balance, String email, String phone
		accountService.addAccount(new Account("ravi", 1000,"ravi@gmail.com","889900334"));
		accountService.addAccount(new Account("anil", 1000,"anil@gmail.com","994433311"));
		
		System.out.println("---------accounts are added---");
		
	}

}
