package com.productapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.dto.Product;
import com.productapp.service.ProductClientService;

@RestController
public class ProductClientController {
	
	private ProductClientService productClientService;

	@Autowired
	public ProductClientController(ProductClientService productClientService) {
		this.productClientService = productClientService;
	}
	@GetMapping(path = "products/{id}")
	public Product getById(@PathVariable(name="id")  int id) {
		return productClientService.getById(id);
	}

}
