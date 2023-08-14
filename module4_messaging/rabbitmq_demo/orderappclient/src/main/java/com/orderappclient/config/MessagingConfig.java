package com.orderappclient.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {
	
	public static final String JAVADEMO_ROUTINGKEY = "javademo_routingkey";
	public static final String JAVADEMO_EXCHANGE = "javademo_exchange";
	public static final String JAVADEMO_QUEUE = "javademo_queue";

	//Queue Binding Exchange
	@Bean
	public Queue queue() {
		return new Queue(JAVADEMO_QUEUE);
	}
	
	//Exchange
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(JAVADEMO_EXCHANGE);
	}
	
	//Binding
	@Bean
	public  Binding  binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(JAVADEMO_ROUTINGKEY);
	}

	//it will convert json to java object
	@Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}
	
	//JdbcTemplate vs amqpTemplate
	@Bean
	public AmqpTemplate template(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate=new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(converter());
		
		return rabbitTemplate;
	}
}








