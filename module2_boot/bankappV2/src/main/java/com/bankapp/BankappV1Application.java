package com.bankapp;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class BankappV1Application implements CommandLineRunner{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private EntityManager em;
	
	
	public static void main(String[] args) {
		ApplicationContext ctx=  SpringApplication.run(BankappV1Application.class, args);
		
//		String beansName[]=ctx.getBeanDefinitionNames();
//		for(String beanName: beansName) {
//			System.out.println(beanName);
//		}
	}

	@Override
	public void run(String... args) throws Exception {
		//if i want to write some code just after spring boot started ...
		//i can write some code inside this run method ... spring boot give me gurantee to call this methdod
		if(jdbcTemplate!=null) {
			System.out.println("jdbc templete is configured...");
		}
		
		if(em!=null) {
			System.out.println("em is configured...");
		}
	}

}
