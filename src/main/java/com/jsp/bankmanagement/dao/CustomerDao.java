package com.jsp.bankmanagement.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.bankmanagmentsystem.dto.Account;
import com.jsp.bankmanagmentsystem.dto.Customer;
import com.jsp.bankmanagement.service.AccountService;

public class CustomerDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("sairaj");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public Customer saveCustomer(Customer customer) {
		
		entityTransaction.begin();
		entityManager.persist(customer);
	    entityTransaction.commit();
		return customer;
	}
	
	public Customer getCustomerById(int id) {
	Customer customer =	entityManager.find(Customer.class, id);
		return customer;
	}
	
	public List<Customer> getAllCustomer(){
		String sql="select s from Customer s";
		Query query = entityManager.createQuery(sql);
		List<Customer> cutomers = query.getResultList();
		return cutomers;
	}
	
	public Customer updateCustomer(Customer customer) {
        entityTransaction.begin();
        entityManager.merge(customer);
        entityTransaction.commit();
		return customer;
	}
	
	public void deleteCustomerById(int id) {
	Customer customer =	entityManager.find(Customer.class, id);
		entityTransaction.begin();
		entityManager.remove(customer);
		entityTransaction.commit();
	}
	
	
	
	public double checkAccountBalance(int id) {
		Customer customer = entityManager.find(Customer.class, id);
		double balance = customer.getAccount().getAccountBalance();
		return balance;
	}
	
	public Account getAccountDetails(long accountNo) {
		AccountService accountService=new AccountService();
		Account account=accountService.getAccountById(accountNo);
		return account;
	}


}
