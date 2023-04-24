package com.jsp.bankmanagement.controller.customer;
import com.jsp.bankmanagmentsystem.dto.Customer;
import com.jsp.bankmanagement.service.CustomerService;

public class RegisterCustomer {
	
	public static void main(String[] args) {
		Customer customer=new Customer();
		customer.setName("abc");
		customer.setEmail("abc@gmail.com");
		customer.setPhone("7977889089");
		customer.setStatus("Unapproved");
		customer.setAge(22);
		customer.setDOB("06/02/2001");
		customer.setAdharNo("333888887733");
		customer.setAccountType("Saving");
		
		CustomerService customerService=new CustomerService();
		customerService.registerCustomer(customer);
		
	}

}
