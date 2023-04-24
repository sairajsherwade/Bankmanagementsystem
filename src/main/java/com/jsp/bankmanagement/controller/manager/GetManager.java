package com.jsp.bankmanagement.controller.manager;
import com.jsp.bankmanagmentsystem.dto.BankManager;
import com.jsp.bankmanagement.service.BankManagerService;

public class GetManager {
	public static void main(String[] args) {
		BankManagerService bankManagerService=new BankManagerService();
		BankManager bankManager = bankManagerService.getManagerById(2);
		System.out.println(bankManager.getManagerName());
	}

}
