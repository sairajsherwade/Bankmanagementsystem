package com.jsp.bankmanagement.controller.manager;
import com.jsp.bankmanagmentsystem.dto.BankManager;
import com.jsp.bankmanagement.service.BankManagerService;

public class UpdateManager {
	
	public static void main(String[] args) {
		BankManagerService bankManagerService=new BankManagerService();
		BankManager bankManager = bankManagerService.updateManagerName(1, "Rushi");
		System.out.println(bankManager.getManagerName());
	}

}

