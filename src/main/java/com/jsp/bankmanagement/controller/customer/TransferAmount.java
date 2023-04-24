package com.jsp.bankmanagement.controller.customer;
import com.jsp.bankmanagement.service.AccountService;

public class TransferAmount {
      
	public static void main(String[] args) {
		AccountService accountService=new AccountService();
		accountService.transferAmount(2, 1, 100);
	}
}