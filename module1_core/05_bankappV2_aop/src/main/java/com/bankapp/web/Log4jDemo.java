package com.bankapp.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jDemo {
	private static Logger logger=LoggerFactory.getLogger(Log4jDemo.class);
	
			
	public static void main(String[] args) {
		//logging concept : log4j
		System.out.println("code is working till line no 6");
		logger.info("code is working till line no 13");
		
		System.out.println("code is working till line no 15");
		
		
		System.out.println("code is working till line no 31");
	}
	

}
