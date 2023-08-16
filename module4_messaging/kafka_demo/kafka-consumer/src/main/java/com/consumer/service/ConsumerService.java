package com.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.producer.dto.Product;

@Service
public class ConsumerService {
	
	@KafkaListener(topics = "demoraj2", groupId = "my_topic_group_id")
	public void consume(Product product) {
		System.out.println("product is consumed-------------");
		System.out.println(product);
	}

}
