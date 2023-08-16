package com.mutualfunds.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mutualfunds.dao.InvestmentOptionDao;
import com.mutualfunds.entities.InvestmentOption;
import com.mutualfunds.services.InvestmentOptionService;

@Service
public class InvestmentOptionServiceImpl implements InvestmentOptionService {

	private InvestmentOptionDao investmentOptionDao;

	@Autowired
	public InvestmentOptionServiceImpl(InvestmentOptionDao investmentOptionDao) {
		this.investmentOptionDao = investmentOptionDao;
	}

	@Override
	public List<InvestmentOption> getAll() {
		return investmentOptionDao.findAll();
	}

	@Override
	public InvestmentOption getById(int id) {
		return investmentOptionDao.getById(id);
	}

	@Override
	public void addInvestmentOption(InvestmentOption investmentOptions) {
		investmentOptionDao.save(investmentOptions);
	}

	@Override
	public InvestmentOption updateInvestmentOption(int id, InvestmentOption investmentOptions) {
		InvestmentOption toUpdate = investmentOptionDao.getById(id);
		toUpdate.setType(toUpdate.getType());
		toUpdate.setMaturityDate(toUpdate.getMaturityDate());
		toUpdate.setCurrentPrice(toUpdate.getCurrentPrice());
		toUpdate.setMarketCap(toUpdate.getMarketCap());
		toUpdate.setUnits(toUpdate.getUnits());
		investmentOptionDao.save(toUpdate);
		return toUpdate;
	}

	@Override
	public void deleteInvestmentOption(int id) {
		InvestmentOption toDelete = investmentOptionDao.getById(id);
		investmentOptionDao.delete(toDelete);

	}

	@Override
	public List<InvestmentOption> getTop10(String type) {
		return null;
	}

}













