package com.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class UpdateAccount {
	
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("orapu");
		
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction tx=em.getTransaction();
		
		try {
			tx.begin();
			//we need tx mgt while update the account object
			//1. get the account object
			Account accountToUpdate=em.find(Account.class, 1);
		
			
			//2. change the balance 
			accountToUpdate.setBalance(accountToUpdate.getBalance()+100);
			
			
			//3. update it
			em.merge(accountToUpdate);
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
		}
		em.close();
		emf.close();
		
	}

}





