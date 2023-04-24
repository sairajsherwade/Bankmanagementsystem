package com.jsp.bankmanagement.controller.manager;
import com.jsp.bankmanagement.service.BankManagerService;

public class DeleteManager {
	public static void main(String[] args) {
		BankManagerService bankManagerService=new BankManagerService();
		bankManagerService.deleteManagerById(2);
	}

}