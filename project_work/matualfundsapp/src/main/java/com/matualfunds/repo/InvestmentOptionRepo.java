package com.matualfunds.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matualfunds.entities.InvestmentOption;
@Repository
public interface InvestmentOptionRepo extends JpaRepository<InvestmentOption, Integer> {

}
