package com.jsp.bankmanagement.controller.manager;
import com.jsp.bankmanagement.service.BankManagerService;

public class ApprovedCustomer {
	
	public static void main(String[] args) {
		BankManagerService bankManagerService=new BankManagerService();
		bankManagerService.approvedCustomer(2,1);
	}

}