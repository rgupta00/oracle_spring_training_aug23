package com.productapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.dto.Product;

@RestController
public class ProductController {

	@GetMapping(path = "products/{id}")
	public Product getById(@PathVariable(name="id")  int id) {
		return new Product(id, "laptop", 236000);
	}
}
