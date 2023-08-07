package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
	
		//pull Passanger is pulling its depdencies..
		//syn become more complicated
		
		//push : rather then passanger is looking for vehicle ....
		//vehicle is pushed to the passange
		
		//I want that spring should create object of Passanger and create car and assign
		//car to the passanger 
		ApplicationContext ctx=
				new ClassPathXmlApplicationContext("demo.xml");
		
		Passanger passanger=(Passanger) ctx.getBean("p");
		passanger.travel();
		
		
	}

}
