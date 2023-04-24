package com.jsp.bankmanagement.controller.admin;
import com.jsp.bankmanagement.service.BankAdminService;
import com.jsp.bankmanagmentsystem.dto.BankAdmin;
public class GetAdmin {

	public static void main(String[] args) {
		BankAdminService bankAdminService=new BankAdminService();
		BankAdmin bankAdmin = bankAdminService.getAdminById(1);
		System.out.println(bankAdmin.getAdminEmail());
	}

}
