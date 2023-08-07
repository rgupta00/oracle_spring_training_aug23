package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
	
		//ClassPathXmlApplicationContext : only support xml
		//AnnotationConfigApplicationContext: support java config
		AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		Passanger passanger=(Passanger) ctx.getBean("p");
		passanger.travel();
		
		
	}

}
