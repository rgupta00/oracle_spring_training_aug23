package com.mutualfunds.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mutualfunds.entities.Investor;

public interface InvestorDao extends JpaRepository<Investor, Integer>{
}
