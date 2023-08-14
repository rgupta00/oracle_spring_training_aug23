package com.orderappclient.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.orderappclient.config.MessagingConfig;
import com.orderappclient.dto.OrderStatus;

@Service
public class OrderConsumer {
	
	@RabbitListener(queues = MessagingConfig.JAVADEMO_QUEUE)
	public void consumeMessage(OrderStatus orderStatus) {
		System.out.println("consumed message: "+ orderStatus);
		
	}

}
