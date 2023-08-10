package com.productapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProductappclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductappclientApplication.class, args);
	}

	//resttemplate is an abstraction to call remote api
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
