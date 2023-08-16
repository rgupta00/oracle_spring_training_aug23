package com.mutualfunds;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mutualfunds.entities.InvestmentOption;
import com.mutualfunds.entities.Investor;
import com.mutualfunds.services.InvestmentOptionService;
import com.mutualfunds.services.InvestorService;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner{
	
	@Autowired
	private InvestorService investorService;
	@Autowired
	private InvestmentOptionService investmentOptionService;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		investorService.addInvestor(new Investor("abhi", "9023773642", "jhwvejc@jdwecjh", "bajdvxc", "jhwegcedihc"));
		investorService.addInvestor(new Investor("shiv", "9027624642", "jhwvejc@jdwecjh", "bajdvxc", "jhwegcedihc"));
		investmentOptionService.addInvestmentOption(new InvestmentOption("bonds", "ask", LocalDate.of(2024, 1, 1), 100.23, 100000.00, 4));
		investmentOptionService.addInvestmentOption(new InvestmentOption("stocks", "xyz", LocalDate.of(2024, 3, 9), 400.00, 100000.00, 10));
		investmentOptionService.addInvestmentOption(new InvestmentOption("index", "bht", LocalDate.of(2024, 8, 12), 100.23, 100000.00, 8));
		investmentOptionService.addInvestmentOption(new InvestmentOption("commodities", "rtc", LocalDate.of(2024, 11, 1), 198.17, 100000.00, 6));
		investmentOptionService.addInvestmentOption(new InvestmentOption("bonds", "efg", LocalDate.of(2024, 2, 3), 220.89, 100000.00, 3));
	
	}

}
