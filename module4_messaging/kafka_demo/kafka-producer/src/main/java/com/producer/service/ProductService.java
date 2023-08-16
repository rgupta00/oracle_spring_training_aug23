package com.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.producer.dto.Product;

@Service
public class ProductService {
	
	@Autowired
	private KafkaTemplate<String, Product> kafkaTemplate;
	
	
	public void produce(Product product) {
		kafkaTemplate.send("demoraj2", product);
		System.out.println("message is send");
	}

}
