package com.mutualfunds.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutualfunds.dao.InvestorDao;
import com.mutualfunds.entities.Investor;
import com.mutualfunds.exceptions.InvestorNotFoundException;
import com.mutualfunds.services.InvestorService;
@Service
public class InvestorServiceImpl implements InvestorService {

	private InvestorDao investorDao;
	
	@Autowired
	public InvestorServiceImpl(InvestorDao investorDao) {
		this.investorDao = investorDao;
	}

	@Override
	public List<Investor> getAll() {
		return investorDao.findAll();
	}

	@Override
	public Investor getById(int id) {
		Investor investor= 
				investorDao.findById(id)
				.orElseThrow(()->new InvestorNotFoundException("investor not found with id: " + id));
		return investor;
	}

	@Override
	public void addInvestor(Investor investor) {
		investorDao.save(investor);
	}

	@Override
	public Investor updateInvestor(int id,Investor investor) {
		Investor investorToUpdate = investorDao.getById(id);
		investorToUpdate.setName(investor.getName());
		investorToUpdate.setMobileNo(investor.getMobileNo());
		investorToUpdate.setEmail(investor.getEmail());
		investorToUpdate.setAddress(investor.getAddress());
		investorDao.save(investorToUpdate);
		return investorToUpdate;
	}

	@Override
	public void deleteInvestor(int id) {
		investorDao.delete(investorDao.getById(id));

	}

}
