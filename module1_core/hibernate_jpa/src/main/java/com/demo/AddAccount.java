package com.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class AddAccount {
	
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("orapu");
		
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction tx=em.getTransaction();
		
		try {
			tx.begin();
			
			Account account=new Account("sunita", 1000);
			
			Account account2=new Account("pooja", 1000);
			
			Account account3=new Account("naveen", 1000);
			
			em.persist(account);
			em.persist(account2);
			em.persist(account3);
			
			
			
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
		}
		em.close();
		emf.close();
		
	}

}





