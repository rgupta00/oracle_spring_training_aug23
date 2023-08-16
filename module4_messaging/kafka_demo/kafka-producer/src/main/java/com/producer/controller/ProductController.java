package com.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.producer.dto.Product;
import com.producer.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@PostMapping(path = "produce")
	public String produceProduct( @RequestBody  Product product) {
		
		productService.produce(product);
		
		return "product added successfully";
	}

}
