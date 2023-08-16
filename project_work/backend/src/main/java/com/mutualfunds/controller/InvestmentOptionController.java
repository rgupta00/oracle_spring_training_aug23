package com.mutualfunds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mutualfunds.entities.InvestmentOption;
import com.mutualfunds.services.InvestmentOptionService;

@RestController
@RequestMapping(path = "investmentoptions")
public class InvestmentOptionController {

	private InvestmentOptionService investmentOptionService;

	@Autowired
	public InvestmentOptionController(InvestmentOptionService investmentOptionService) {
		super();
		this.investmentOptionService = investmentOptionService;
	}

	// all investment options
	@GetMapping
	public List<InvestmentOption> getAll() {
		return investmentOptionService.getAll();
	}

	// get using id
	@GetMapping(path = "{id}")
	public InvestmentOption getById(@PathVariable(name = "id") int id) {
		return investmentOptionService.getById(id);
	}

	// get top 10 investment options by type
	@GetMapping(path = "top10/{type}")
	public List<InvestmentOption> getTop10(@PathVariable(name = "type") String type) {
		return investmentOptionService.getTop10(type);
	}

	// creating a new investment options
	@PostMapping
	public void addInvestmentOption(InvestmentOption investmentOption) {
		investmentOptionService.addInvestmentOption(investmentOption);
	}

	// updating investment options
	@PutMapping(path = "{id}")
	public InvestmentOption updateInvestmentOption(@PathVariable(name = "id") int id,
			InvestmentOption investmentOption) {
		investmentOptionService.updateInvestmentOption(id, investmentOption);
		return investmentOption;
	}

	// deleting investment options
	@DeleteMapping(path = "{id}")
	public void deleteInvestmentOption(@PathVariable(name = "id") int id) {
		investmentOptionService.deleteInvestmentOption(id);
	}

}
