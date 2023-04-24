package com.jsp.bankmanagement.controller.manager;
import java.util.List;

import com.jsp.bankmanagmentsystem.dto.Customer;
import com.jsp.bankmanagement.service.BankManagerService;

public class GetAllUnapprovedCustomer {
	
     public static void main(String[] args) {
		BankManagerService bankManagerService=new BankManagerService();
	  List<Customer> customers = bankManagerService.viewAllUnapprovedCustomer(1);
	  for(Customer c:customers) {
		  System.out.println(c.getId());
		  System.out.println(c.getAccountType());
		  System.out.println(c.getAdharNo());
		  System.out.println(c.getAge());
		  System.out.println(c.getEmail());
		  System.out.println(c.getDOB());
		  System.out.println(c.getStatus());
		  System.out.println("================");
	  }
	}

}
