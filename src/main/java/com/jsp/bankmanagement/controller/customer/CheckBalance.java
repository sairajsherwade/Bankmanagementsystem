package com.jsp.bankmanagement.controller.customer;
import com.jsp.bankmanagement.service.CustomerService;

public class CheckBalance {

	public static void main(String[] args) {
		CustomerService customerService=new CustomerService();
		double amount= customerService.checkAccountBalance(2);
		System.out.println(amount);
	}
}
