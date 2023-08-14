package com.orderapp.controller;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.OrderComparator.OrderSourceProvider;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderapp.config.MessagingConfig;
import com.orderapp.dto.Order;
import com.orderapp.dto.OrderStatus;

@RestController
@RequestMapping(path = "/order")
public class OrderPublisher {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@PostMapping(path = "{restaurantName}")
	public String bookOrder(@RequestBody  Order order, @PathVariable  String restaurantName) {
		order.setOrderId(UUID.randomUUID().toString());
		
		OrderStatus orderStatus=new OrderStatus();
		orderStatus.setOrder(order);
		orderStatus.setStatus("PENDING");
		orderStatus.setMessage("Order is booked");
		
		rabbitTemplate.convertAndSend(MessagingConfig.JAVADEMO_EXCHANGE, 
				MessagingConfig.JAVADEMO_ROUTINGKEY, orderStatus);
		
		return "order is booked";
	}
	

}
