package com.jsp.bankmanagement.service;
import com.jsp.bankmanagement.dao.AccountDao;
import com.jsp.bankmanagmentsystem.dto.Account;
import com.jsp.bankmanagmentsystem.dto.Customer;

public class AccountService {
AccountDao accountDao=new AccountDao();
	
	public boolean transferAmount(long senderAccountNo,long receiverAccountNo,double amountToTranfer) {
		  Account account =accountDao.getAccountById(senderAccountNo);
		  double accountBal = account.getAccountBalance();
		  if(accountBal>amountToTranfer) {
		  double remainingAmount=accountBal-amountToTranfer;
		  account.setAccountBalance(remainingAmount);
		  accountDao.transferAmount(account);
		  AccountService accountService=new AccountService();
		  boolean b= accountService.depositeAmountToAccount(receiverAccountNo, amountToTranfer);
		  if(b==true) {
			  System.out.println("Amount is transfer succesfully");
			  return true;
		  }else {
			  System.out.println("Somthing went wrong");
			  return false;
		  }
		  
		  }else {
			  System.out.println("Insufficient Account Balance");
			  return false;
		  }
		  
		}
	
	public boolean depositeAmountToAccount(long acountNo,double receivedAmount) {
		Account account = accountDao.getAccountById(acountNo);
		double previousAcountBal = account.getAccountBalance();
		double newAccountBal =previousAcountBal+receivedAmount;
		account.setAccountBalance(newAccountBal);
	    accountDao.updateAmount(account);
	    return true;
	
	}
	
	public Account getAccountById(long id) {
		if(id>0) {
		Account account = accountDao.getAccountById(id);
		return account;
	}else {
		return null;
	}
	
}
	public Account openAccount(Customer customer) {
		if(customer.getAge()<18) {
		Account account = new Account();
		account.setAccountNo(customer.getId());
		account.setAccountBalance(0.0);
		account.setAccountType(customer.getAccountType()+"/Minor");
		account.setCustomer(customer);
		customer.setAccount(account);
		Account account2 = accountDao.openAccount(account, customer);
		return account2;
		}else {
			Account account = new Account();
			account.setAccountNo(customer.getId());
			account.setAccountBalance(0.0);
			account.setAccountType(customer.getAccountType()+"/Major");
			account.setCustomer(customer);
			customer.setAccount(account);
			Account account2 = accountDao.openAccount(account, customer);
			return account2;
		}
	}
	
	public Account saveAccount(Account account) {
		Account account2 = accountDao.openAccount(account);
		return account2;
	}

}
