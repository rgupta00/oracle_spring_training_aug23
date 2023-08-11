package com.customerapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.customerapp.dto.Customer;

@RestController
public class CustomerController {

	@GetMapping(path = "customers/{id}")
	public Customer getById(@PathVariable(name="id")  int id) {
		return new Customer(id, "ravi", "ravi@gmail.com");
	}
}
