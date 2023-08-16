package com.matualfunds.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matualfunds.entities.Investor;
import com.matualfunds.exceptions.ResouceNotFoundException;
import com.matualfunds.repo.InvestorRepo;
import com.matualfunds.services.InvestorService;
@Service
@Transactional
public class InvestorServiceImpl implements InvestorService{

	
	private InvestorRepo investorRepo;
	
	@Autowired
	public InvestorServiceImpl(InvestorRepo investorRepo) {
		this.investorRepo = investorRepo;
	}

	@Override
	public List<Investor> getAll() {
		return investorRepo.findAll();
	}

	@Override
	public Investor getById(int id) {
		return investorRepo.findById(id)
				.orElseThrow(()-> new ResouceNotFoundException("investor is not found "));
	}

	@Override
	public void addInvestor(Investor investor) {
		investorRepo.save(investor);
	}

	@Override
	public Investor updateInvestor(int id, Investor investor) {
		Investor investorToUpdate=getById(id);
		investorToUpdate.setMobileNo(investor.getMobileNo());
		investorToUpdate.setAddress(investor.getAddress());
		investorToUpdate.setEmail(investor.getEmail());
		investorToUpdate.setPassword(investor.getPassword());
		investorRepo.save(investorToUpdate);
		
		return investorToUpdate;
	}

	@Override
	public void deleteInvestor(int id) {
		Investor investorToDelete=getById(id);
		investorRepo.delete(investorToDelete);
	}

	@Override
	public List<Investor> getAllByName(String name) {
		
		return investorRepo.getInvestorsByNameByQuery(name);
	}

}
