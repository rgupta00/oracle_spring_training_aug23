package com.matualfunds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.matualfunds.entities.Investor;
import com.matualfunds.services.InvestorService;


@SpringBootApplication
public class MatualfundsappApplication implements CommandLineRunner{

	@Autowired
	private InvestorService investorService;
	
	public static void main(String[] args) {
		SpringApplication.run(MatualfundsappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		investorService.addInvestor(new Investor("abhi kumar", "9023773642", "jhwvejc@jdwecjh", "bajdvxc", "jhwegcedihc"));
		investorService.addInvestor(new Investor("shiv sharma", "9027624642", "jhwvejc@jdwecjh", "bajdvxc", "jhwegcedihc"));
	
	}

}
