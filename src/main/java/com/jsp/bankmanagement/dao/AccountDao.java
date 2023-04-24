package com.jsp.bankmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.bankmanagmentsystem.dto.Account;
import com.jsp.bankmanagmentsystem.dto.Customer;

public class AccountDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("sairaj");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public Account getAccountById(long id) {
	 Account account =	entityManager.find(Account.class, id);
	 return account;
	}
	
	public List<Account> getAllAccount(){
		String sql="select s from Account s";
		Query query = entityManager.createQuery(sql);
		List<Account> accounts = query.getResultList();
		return accounts;
	}
	
	public boolean transferAmount(Account account) {
		entityTransaction.begin();
		entityManager.merge(account);
		entityTransaction.commit();
		return true;
	}
	
	public Account updateAmount(Account account) {
		entityTransaction.begin();
		entityManager.merge(account);
		entityTransaction.commit();
		return account;
	}
	
	public Account openAccount(Account account,Customer customer) {
		entityTransaction.begin();
		entityManager.persist(account);
		entityManager.merge(customer);
		entityTransaction.commit();
		
		return account;
		
	}
	
	public Account openAccount(Account account) {
		entityTransaction.begin();
		entityManager.persist(account);
		entityTransaction.commit();
		return account;
	}

}
