package com.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class GetById {
	
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("orapu");
		
		EntityManager em=emf.createEntityManager();
		
		Account account=em.find(Account.class, 1);
		System.out.println(account);
		
		
		em.close();
		emf.close();
		
	}

}





