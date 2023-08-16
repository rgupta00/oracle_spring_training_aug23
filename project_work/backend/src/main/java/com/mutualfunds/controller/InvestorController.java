package com.mutualfunds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mutualfunds.entities.Investor;
import com.mutualfunds.services.InvestorService;

@RestController
@RequestMapping(path = "investors")
public class InvestorController {

	private InvestorService investorService;

	@Autowired
	public InvestorController(InvestorService investorService) {
		this.investorService = investorService;
	}

	@GetMapping
	public List<Investor> getAll() {
		return investorService.getAll();
	}

	@GetMapping(path = "{id}")
	public Investor getById(@PathVariable(name = "id") int id) {
		return investorService.getById(id);
	}

	@PostMapping
	public String addInvestor(@RequestBody Investor investor) {
		investorService.addInvestor(investor);
		return "investor added succesfully with id " + investor.getInvestorId();
	}

	@PutMapping(path = "{id}")
	public String updateInvestor(@PathVariable(name = "id") int id, @RequestBody Investor investor) {
		investorService.updateInvestor(id, investor);
		return "investor updated succesfully with id " + id;
	}
	
	@DeleteMapping(path="{id}")
	public String deleteInvestor(@PathVariable(name="id") int id) {
		investorService.deleteInvestor(id);
		return "investor deleted succesfully with id + " + id;
	}
}
