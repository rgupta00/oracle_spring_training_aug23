package com.productapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.productapp.dto.Product;

@Service
public class ProductClientService {
	
	private RestTemplate restTemplate;

	@Autowired
	public ProductClientService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public Product getById(int id) {
		return restTemplate.getForObject("http://localhost:8090/products/"+id, Product.class);
	}
	

}
