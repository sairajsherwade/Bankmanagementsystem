package com.jsp.bankmanagement.service;
import java.util.List;

import com.jsp.bankmanagement.dao.AccountDao;
import com.jsp.bankmanagement.dao.CustomerDao;
import com.jsp.bankmanagmentsystem.dto.Account;
import com.jsp.bankmanagmentsystem.dto.Customer;

public class CustomerService {
CustomerDao customerDao=new CustomerDao();
	
	
	public void getAccountDetails(long accountNo) {
		Account account= customerDao.getAccountDetails(accountNo);
		System.out.println(account.getAccountNo());
		System.out.println(account.getAccountBalance());
	}
	
	public Customer registerCustomer(Customer customer) {
		if(customer!=null) {
			Customer customer2 = customerDao.saveCustomer(customer);
			if(customer2!=null) {
				System.out.println("Customer is added succesfully");
				return customer2;
			}
			return null;
		}else {
			return null;
		}
	}
	
	public Customer getCustomerById(int id) {
		if(id>0) {
		Customer customer =	customerDao.getCustomerById(id);
		return customer;
		}else {
			return null;
		}
	}
	
	public List<Customer> getAllCustomer(){
	  List<Customer> customers = customerDao.getAllCustomer();
	  return customers;
	}
	
	public Customer updateCustomerEmail(int id,String email) {
	
	  Customer customer = customerDao.getCustomerById(id);
	  if(customer.getStatus().compareToIgnoreCase("Approved")==0) {
	  customer.setEmail(email);
	  Customer customer2 = customerDao.updateCustomer(customer);
	  return customer2;
	  }else {
		  System.out.println("Invalid customer");
		  return null;
	  }
	  
	}
	
	public Account updateCustomerAccountBalance(int id,double accountBalance) {
		
		  Customer customer = customerDao.getCustomerById(id);
		  if(customer.getStatus().compareToIgnoreCase("Approved")==0) {
		  Account account = customer.getAccount();
		  account.setAccountBalance(accountBalance);
		  AccountService accountService=new AccountService();
		  accountService.depositeAmountToAccount(id, accountBalance);
		  return account;
		  }else {
			  System.out.println("Invalid customer");
			  return null;
		  }
		  
		}
	
	public void depositeToAccount(long accountNo,double amountToTransfer) {
		AccountDao accountDao=new AccountDao();
		Account account = accountDao.getAccountById(accountNo);
		AccountService accountService=new AccountService();
		boolean b=accountService.depositeAmountToAccount(account.getAccountNo(), amountToTransfer);
		if(b==true) {
			accountDao.updateAmount(account);
		}
	}
	
	public double checkAccountBalance(long accountNo) {
		AccountService accountService=new AccountService();
		Account account = accountService.getAccountById(accountNo);
		Customer customer= account.getCustomer();
		double balance = customerDao.checkAccountBalance(customer.getId());
		return balance;
	}
	
	
	
	public Customer updateCustomerName(int id,String name) {
		  Customer customer = customerDao.getCustomerById(id);
		  if(customer.getStatus().compareToIgnoreCase("Approved")==0) {
		  customer.setName(name);
		  Customer customer2 = customerDao.updateCustomer(customer);
		  return customer2;
		  }else {
			  System.out.println("Invalid customer");
			  return null;
		  }
		  
	}
	
	public Customer updateCustomerPhone(int id,String phone) {
		  Customer customer = customerDao.getCustomerById(id);
		  if(customer.getStatus().compareToIgnoreCase("Approved")==0) {
		  customer.setPhone(phone);
		  Customer customer2 = customerDao.updateCustomer(customer);
		  return customer2;
		  }else {
			  System.out.println("Invalid customer");
			  return null;
		  }
		  
		}
	public Customer updateCustomerStatus(int id,String status) {
		  Customer customer = customerDao.getCustomerById(id);
		  customer.setStatus(status);
		  Customer customer2 = customerDao.updateCustomer(customer);
		  return customer2;
		  
		}
	
	public void deleteCustomerById(int id) {
		Customer customer = customerDao.getCustomerById(id);
		if(customer.getStatus().compareToIgnoreCase("Approved")==0) {
		customerDao.deleteCustomerById(id);
	       }
		}

}
