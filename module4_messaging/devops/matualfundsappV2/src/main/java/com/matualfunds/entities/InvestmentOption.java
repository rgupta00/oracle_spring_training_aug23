package com.matualfunds.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "invest_mentOption_table")
public class InvestmentOption {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int optionId;
	private String type;
	private String name;
	private LocalDate maturityDate;
	private double currentPrice;
	private double marketCap;
	private int units;
	
	
	
	public InvestmentOption() {}



	public InvestmentOption(String type, String name, LocalDate maturityDate, double currentPrice, double marketCap,
			int units) {
		super();
		this.type = type;
		this.name = name;
		this.maturityDate = maturityDate;
		this.currentPrice = currentPrice;
		this.marketCap = marketCap;
		this.units = units;
	}



	public InvestmentOption(int optionId, String type, String name, LocalDate maturityDate, double currentPrice,
			double marketCap, int units) {
		super();
		this.optionId = optionId;
		this.type = type;
		this.name = name;
		this.maturityDate = maturityDate;
		this.currentPrice = currentPrice;
		this.marketCap = marketCap;
		this.units = units;
	}
	
	
	
}
