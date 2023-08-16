package com.matualfunds.controller;

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

import com.matualfunds.entities.Investor;
import com.matualfunds.services.InvestorService;

@RestController
@RequestMapping(path = "api/v1")
public class InvestorController {
	
	private InvestorService investorService;

	@Autowired
	public InvestorController(InvestorService investorService) {
		this.investorService = investorService;
	}
	
	//get all the investors
	@GetMapping(path = "investors")
	public List<Investor> getAll(){
		return investorService.getAll();
	}
	
	//get investor by id
	@GetMapping(path = "investorsbyid/{id}")
	public Investor getById(@PathVariable int id){
		return investorService.getById(id);
	}
	
	@GetMapping(path = "investorsbyname/{name}")
	public List<Investor> getByName(@PathVariable String name){
		return investorService.getAllByName(name);
	}
	
	//add new investor
	@PostMapping(path = "investors")
	public void addInvestor( @RequestBody Investor investor){
		 investorService.addInvestor(investor);
	}
	
	
	//update contact details of investor
	
	@PutMapping(path = "investors/{id}")
	public void updateInvestor(@PathVariable int id,  @RequestBody Investor investor){
		 investorService.updateInvestor(id, investor);
	}
	
	
	
	//delete an investor
	@DeleteMapping(path = "investors/{id}")
	public void deleteById(@PathVariable int id){
		 investorService.deleteInvestor(id);
	}
	
	
	

}









