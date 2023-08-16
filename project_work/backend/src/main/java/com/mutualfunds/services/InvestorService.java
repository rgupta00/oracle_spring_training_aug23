package com.mutualfunds.services;

import java.util.List;

import com.mutualfunds.entities.Investor;

public interface InvestorService {
	
	public List<Investor> getAll();
	
	public Investor getById(int id);
	
	public void addInvestor(Investor investor);
	
	public Investor updateInvestor(int id, Investor investor);
	
	public void deleteInvestor(int id);
}
