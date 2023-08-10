package com.productapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.entities.Product;
import com.productapp.service.ProductService;
//CommandLineRunner is a interface it have on run(...) method that run just after spring boot is started
//u can write some db initilzation code
@SpringBootApplication
public class Productappv1Application implements CommandLineRunner{

	@Autowired
	private ProductService productService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Productappv1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productService.addProduct(new Product("rich dad poor dad", 200));
		productService.addProduct(new Product("dell laptop", 123200));
		
	}

}
