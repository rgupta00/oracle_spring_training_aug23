package com.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class ShowAllAccount {
	
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("orapu");
		
		EntityManager em=emf.createEntityManager();
		
		//reading all records No need of tx mgt
		List<Account> accounts=em.createQuery("select a from Account a",Account.class)
				.getResultList();
		for(Account account: accounts) {
			System.out.println(account);
		}
		
		em.close();
		emf.close();
		
	}

}





