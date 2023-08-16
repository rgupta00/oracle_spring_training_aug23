package com.mutualfunds.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "invest_options_table")
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

	// default constructor
	public InvestmentOption() {
		super();
	}

	// parameterized constructor
	public InvestmentOption(int optionId, String type, String name, LocalDate maturityDate, double currentPrice,
			double marketCap, int units) {
		this.optionId = optionId;
		this.type = type;
		this.name = name;
		this.maturityDate = maturityDate;
		this.currentPrice = currentPrice;
		this.marketCap = marketCap;
		this.units = units;
	}

	// constructor to create new investment options
	public InvestmentOption(String type, String name, LocalDate i, double currentPrice,double marketCap, int units) {
		this.type = type;
		this.name = name;
		this.maturityDate = i;
		this.currentPrice = currentPrice;
		this.marketCap = marketCap;
		this.units = units;
	}

	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(LocalDate maturityDate) {
		this.maturityDate = maturityDate;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public double getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(double marketCap) {
		this.marketCap = marketCap;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	@Override
	public String toString() {
		return "InvestmentOptions [optionId=" + optionId + ", publicType=" + type + ", name=" + name
				+ ", maturityDate=" + maturityDate + ", currentPrice=" + currentPrice + ", marketCap=" + marketCap
				+ ", units=" + units + "]";
	};

}
