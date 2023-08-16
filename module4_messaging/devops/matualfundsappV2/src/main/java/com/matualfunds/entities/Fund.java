package com.matualfunds.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//enum bonds,stocks,gold,ppf,epf
import javax.persistence.Table;

@Entity
@Table(name = "fund_table")
public class Fund {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fundId;
	private String fundName;
	private double entryLoad;
	private double exitLoad;
	private double expense_ratio;
	private double interest;
	private double cash_balance;
	
	@Enumerated(EnumType.STRING)
	private InvestmentType investmentType;
	
	private double percentageInvestment;
	
	
	
	//enum bonds,stocks,gold,ppf,epf
	
	
}
