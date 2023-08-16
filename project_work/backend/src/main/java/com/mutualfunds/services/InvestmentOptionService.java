package com.mutualfunds.services;

import java.util.List;

import com.mutualfunds.entities.InvestmentOption;

public interface InvestmentOptionService {

	// get all investment options
	public List<InvestmentOption> getAll();

	// get by id
	public InvestmentOption getById(int id);

	// add investment options
	public void addInvestmentOption(InvestmentOption investmentOptions);

	//update investment options
	public InvestmentOption updateInvestmentOption(int id,InvestmentOption investmentOptions);
	
	//delete investment options
	public void deleteInvestmentOption(int id);
	
	//get top 10 investment options by type
	public List<InvestmentOption> getTop10(String type);
}
