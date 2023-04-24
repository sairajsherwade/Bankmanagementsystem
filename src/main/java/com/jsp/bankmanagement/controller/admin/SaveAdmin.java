package com.jsp.bankmanagement.controller.admin;
import com.jsp.bankmanagmentsystem.dto.BankAdmin;
import com.jsp.bankmanagement.service.BankAdminService;
public class SaveAdmin {
	
	public static void main(String[] args) {
		BankAdmin bankAdmin = new BankAdmin();
				
				bankAdmin.setAdminName("Ranger");
				bankAdmin.setAdminEmail("Ranger@gmail.com");
				bankAdmin.setPhone("9990202020");
				
				BankAdminService bankAdminService=new BankAdminService();
				bankAdminService.saveBankAdmin(bankAdmin);
			}

}
