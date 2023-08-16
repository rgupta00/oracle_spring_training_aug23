package com.matualfunds.services;

import java.util.List;

import com.matualfunds.entities.Investor;

public interface InvestorService {
	
public List<Investor> getAll();
	
	public Investor getById(int id);
	
	public List<Investor> getAllByName(String name);
	
	public void addInvestor(Investor investor);
	
	public Investor updateInvestor(int id, Investor investor);
	
	public void deleteInvestor(int id);
}
