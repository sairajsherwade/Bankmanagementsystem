package com.jsp.bankmanagement.controller.customer;
import com.jsp.bankmanagement.service.CustomerService;

public class AccountDetails {

	public static void main(String[] args) {
		CustomerService customerService=new CustomerService();
		customerService.getAccountDetails(1);
	}

}

