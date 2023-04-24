package com.jsp.bankmanagement.controller.customer;
import com.jsp.bankmanagement.service.CustomerService;

public class DepositeAmount {
	
	public static void main(String[] args) {
		CustomerService customerService=new CustomerService();
		customerService.depositeToAccount(2, 1000);
	}

}