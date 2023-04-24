package com.jsp.bankmanagement.controller.manager;
import com.jsp.bankmanagmentsystem.dto.BankManager;
import com.jsp.bankmanagement.service.BankManagerService;

public class SaveManager {
	
	public static void main(String[] args) {
		BankManager bankManager=new BankManager();
		bankManager.setManagerName("sairaj");
		bankManager.setManagerEmail("sairaj@gmail.com");
		bankManager.setDesignation("Manager");
		bankManager.setStatus("Unapproved");
		BankManagerService bankManagerService = new BankManagerService();
		bankManagerService.saveBankManager(bankManager);
	}

}
