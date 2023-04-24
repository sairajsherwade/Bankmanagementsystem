package com.jsp.bankmanagement.service;

import java.util.List;

import com.jsp.bankmanagement.dao.BankAdminDao;
import com.jsp.bankmanagmentsystem.dto.BankAdmin;


public class BankAdminService {
BankAdminDao bankAdminDao=new BankAdminDao();
	
	public BankAdmin saveBankAdmin(BankAdmin bankAdmin) {
		if(bankAdmin!=null) {
		BankAdmin bankAdmin2 = bankAdminDao.saveBankAdmin(bankAdmin);
		    if(bankAdmin2!=null) {
		    	System.out.println("Admin added succesfully");
		    	
		    }
		    return bankAdmin2;
	}else {
		return null;
	}

  }
	
	public BankAdmin getAdminById(int id) {
		if(id>0) {
	BankAdmin bankAdmin=bankAdminDao.getAdminById(id);
	return bankAdmin;
		}else {
			System.out.println("Invalid Id");
			return null;
		}
	}
	
	public void viewAllUnapprovedManager(int adminId) {
		if(adminId>0) {
	     bankAdminDao.viewAllUnapprovedManager(adminId);
		}
			
	}
	
	public BankAdmin updateAdminName(int id,String name) {
		BankAdmin bankAdmin = bankAdminDao.getAdminById(id);
		bankAdmin.setAdminName(name);
		BankAdmin bankAdmin2 = bankAdminDao.updateBankAdmin(bankAdmin);
		if(bankAdmin2!=null) {
			System.out.println("Admin updated succesfully");
			return bankAdmin2;
		}else {
			return null;
		}
		
	}
	
	public BankAdmin updateAdminEmail(int id,String email) {
		BankAdmin bankAdmin = bankAdminDao.getAdminById(id);
		bankAdmin.setAdminEmail(email);;
		BankAdmin bankAdmin2 =bankAdminDao.updateBankAdmin(bankAdmin);
		if(bankAdmin2!=null) {
			System.out.println("Admin updated succesfully");
			return bankAdmin2;
		}else {
			return null;
		}
		
	}
	
	public BankAdmin updateAdminPhone(int id,String phone) {
		BankAdmin bankAdmin = bankAdminDao.getAdminById(id);
		bankAdmin.setPhone(phone);
		BankAdmin bankAdmin2 = bankAdminDao.updateBankAdmin(bankAdmin);
		if(bankAdmin2!=null) {
			System.out.println("Admin updated succesfully");
			return bankAdmin2;
		}else {
			return null;
		}
		
	}
	
	public void deleteAdminByID(int id) {
		boolean b = bankAdminDao.deleteAdminById(id);
		if(b==true) {
			System.out.println("Admin deleted succesfully");
		}else {
			System.out.println("Not deleted");
		}
	}
	
	public List<BankAdmin> getAllAdmins(){
	  List<BankAdmin> bankAdmins =	bankAdminDao.getAllAdmins();
	  if(bankAdmins!=null) {
		  return bankAdmins;
	  }else {
		  return null;
	  }
	  
	}
	
	

}
