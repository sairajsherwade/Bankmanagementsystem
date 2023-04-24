package com.jsp.bankmanagement.controller.admin;
import com.jsp.bankmanagement.service.BankAdminService;

public class UpdateAdmin {
	public static void main(String[] args) {
		BankAdminService bankAdminService=new BankAdminService();
		bankAdminService.updateAdminEmail(1, "Rushali");
		bankAdminService.updateAdminEmail(1, "Rushali@gmail.com");
	}


}
