package com.jsp.bankmanagement.dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.jsp.bankmanagmentsystem.dto.Account;
import com.jsp.bankmanagmentsystem.dto.BankManager;
import com.jsp.bankmanagmentsystem.dto.Customer;
import com.jsp.bankmanagement.service.AccountService;
import com.jsp.bankmanagement.service.CustomerService;


public class BankManagerDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("sairaj");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public BankManager saveBankManager(BankManager bankManager) {
		if(bankManager!=null) {
			entityTransaction.begin();
			entityManager.persist(bankManager);
			entityTransaction.commit();
			return bankManager;
		}else {
			return null;
		}
		
	}
	
	public BankManager updateBankManager(BankManager bankManager) {
		entityTransaction.begin();
		entityManager.merge(bankManager);
		entityTransaction.commit();
		return bankManager;
	}
	
	public BankManager getManagerById(int id) {
	 BankManager bankManager =	entityManager.find(BankManager.class, id);
		return bankManager;
	}
	
	public void deleteManagerById(int id) {
		
		BankManager bankManager = entityManager.find(BankManager.class, id);
		entityTransaction.begin();
		entityManager.remove(bankManager);
		entityTransaction.commit();
		
		
	}
	
	public List<BankManager> getAllManager(){
		String sql="select s from BankManager s";
	    Query query = entityManager.createQuery(sql);
        List<BankManager> bankManagers = query.getResultList();
        
        return bankManagers;
	}
	
	public List<Customer> viewAllUnapprovedCustomer(){
		CustomerService customerService = new CustomerService();
	    List<Customer> customers = customerService.getAllCustomer();
	    List<Customer> unApproved = new ArrayList<Customer>();
	   
		for(Customer c:customers) {
			if(c.getStatus().compareToIgnoreCase("Unapproved")==0) {
				unApproved.add(c);	
			}	
		}
		
		return unApproved;
}
	
	public Account approvedCustomer(Account account) {
		entityTransaction.begin();
		entityManager.persist(account);
		entityTransaction.commit();
		return account;
	}

}
