package com.bankapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BankappV1Application {

	public static void main(String[] args) {
		ApplicationContext ctx=  SpringApplication.run(BankappV1Application.class, args);
		
//		String beansName[]=ctx.getBeanDefinitionNames();
//		for(String beanName: beansName) {
//			System.out.println(beanName);
//		}
	}

}
