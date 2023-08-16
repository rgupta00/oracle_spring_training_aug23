package com.mutualfunds.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mutualfunds.entities.InvestmentOption;

public interface InvestmentOptionDao extends
		JpaRepository<InvestmentOption, Integer>{

}
