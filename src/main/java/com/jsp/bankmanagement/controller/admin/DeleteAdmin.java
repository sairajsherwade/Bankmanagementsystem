package com.jsp.bankmanagement.controller.admin;
import com.jsp.bankmanagement.service.BankAdminService;
public class DeleteAdmin {
	public static void main(String[] args) {
		BankAdminService bankAdminService=new BankAdminService();
		bankAdminService.deleteAdminByID(3);
	}

}
