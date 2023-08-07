package com.bankapp.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = {"com.bankapp"})
@EnableAspectJAutoProxy	//this annotation help to integrate spring with AspectJ
public class AppConfig {
	
	//u need to write jdbc configuration 
	
	//infra structure bean
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setUsername("root");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/orabatch1?useSSL=false");
		dataSource.setPassword("root");
		return dataSource;
		
	}

}
