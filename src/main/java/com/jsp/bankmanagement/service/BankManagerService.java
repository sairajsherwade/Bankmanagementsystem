package com.jsp.bankmanagement.service;
import java.util.List;

import com.jsp.bankmanagement.dao.AccountDao;
import com.jsp.bankmanagement.dao.BankManagerDao;
import com.jsp.bankmanagement.dao.CustomerDao;
import com.jsp.bankmanagmentsystem.dto.Account;
import com.jsp.bankmanagmentsystem.dto.BankManager;
import com.jsp.bankmanagmentsystem.dto.Customer;

public class BankManagerService {
	BankManagerDao bankManagerDao=new BankManagerDao();
	CustomerService customerService=new CustomerService();
	
	public BankManager saveBankManager(BankManager bankManager) {
		if(bankManager!=null) {
	    BankManager bankManager2 = bankManagerDao.saveBankManager(bankManager);
	    if(bankManager2!=null) {
	    System.out.println("Manager Added Succesfully");
		return bankManager2;
	    }
	    return null;
	}else {
	    return null;
	}
		}
	
	public void deleteManagerById(int id) {
	BankManager bankManager =	bankManagerDao.getManagerById(id);
	if(bankManager.getStatus().compareToIgnoreCase("Unapproved")==0) {
		System.out.println("Manager is not approved by admin");
	}else {
		bankManagerDao.deleteManagerById(id);
		System.out.println("Manager delete succesfully");
	}
	}
	
	
	public BankManager updateManagerStatus(int id,String status) {
		BankManager bankManager = bankManagerDao.getManagerById(id);
	    bankManager.setStatus(status);
		bankManagerDao.updateBankManager(bankManager);
		System.out.println("Updated succesfully");
		return bankManager;
	}
	
	public BankManager updateManagerDesignation(int id,String designation) {
		BankManager bankManager = bankManagerDao.getManagerById(id);
		if(bankManager.getStatus().compareToIgnoreCase("Approved")==0) {
	    bankManager.setDesignation(designation);
		bankManagerDao.updateBankManager(bankManager);
		System.out.println("Updated succesfully");
		return bankManager;
		}else {
			System.out.println("Invalid Manager");
			return null;
		}
		
	}
	
	public BankManager updateManagerEmail(int id,String email) {
		BankManager bankManager = bankManagerDao.getManagerById(id);
		if(bankManager.getStatus().compareToIgnoreCase("Approved")==0) {
	    bankManager.setManagerEmail(email);
		bankManagerDao.updateBankManager(bankManager);
		System.out.println("Updated succesfully");
		return bankManager;
		}else {
			System.out.println("Invalid Manager");
			return null;
		}
		
	}
	
	public BankManager updateManagerName(int id,String name) {
		BankManager bankManager = bankManagerDao.getManagerById(id);
		if(bankManager.getStatus().compareToIgnoreCase("Approved")==0) {
	    bankManager.setManagerName(name);
		bankManagerDao.updateBankManager(bankManager);
		System.out.println("Updated succesfully");
		return bankManager;
		}else {
			System.out.println("Invalid Manager");
		return null;
		}
	}
	
	public List<BankManager> getAllManager(){
		List<BankManager> bankManagers= bankManagerDao.getAllManager();
		return bankManagers;
	}
	
	public List<Customer> viewAllUnapprovedCustomer(int managerId) {
		BankManager bankManager = bankManagerDao.getManagerById(managerId);
		if(bankManager.getStatus().compareToIgnoreCase("Approved")==0) {
		List<Customer> customers = bankManagerDao.viewAllUnapprovedCustomer();
		return customers;
		
	}else {
		return null;
	}
		}
	
	public BankManager getManagerById(int id) {
		if(id>0) {
			BankManager bankManager = bankManagerDao.getManagerById(id);
			if((bankManager.getManagerId()==id) && (bankManager.getStatus().compareToIgnoreCase("Approved")==0)) {
				return bankManager;
			}else {
				System.out.println("Manager is not approved");
				return null;
			}
		}else {
			System.out.println("Invalid Id");
			return null;
		}
	}
	
	public void approvedCustomer(int customerId,int managerId) {
		  BankManager bankManager= bankManagerDao.getManagerById(managerId);
		Customer customer=customerService.getCustomerById(customerId);
		AccountService accountService=new AccountService();
		if(customer.getStatus().compareToIgnoreCase("Unapproved")==0) {
			if(customer.getAdharNo()!=null) {
				customer.setBankManager(bankManager);
				customer.setStatus("Approved");
				customerService.updateCustomerStatus(customer.getId(), customer.getStatus());
				Account account= accountService.openAccount(customer);
				if(account!=null) {
					System.out.println("Customer account is added");
				}
			}else {
				System.out.println("Customer KYC is not complete");
			}
		}
	}

}
