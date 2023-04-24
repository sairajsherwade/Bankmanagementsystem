package com.jsp.bankmanagement.controller.admin;
import com.jsp.bankmanagement.service.BankAdminService;

public class ApprovedManagers {
	public static void main(String[] args) {
		BankAdminService bankAdminService=new BankAdminService();
		bankAdminService.viewAllUnapprovedManager(1);
	}

}
