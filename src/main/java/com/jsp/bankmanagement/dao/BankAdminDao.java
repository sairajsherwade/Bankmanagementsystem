package com.jsp.bankmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.bankmanagmentsystem.dto.BankAdmin;
import com.jsp.bankmanagmentsystem.dto.BankManager;
import com.jsp.bankmanagement.service.BankManagerService;

public class BankAdminDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("sairaj");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public BankAdmin saveBankAdmin(BankAdmin bankAdmin) {
		
		entityTransaction.begin();
		entityManager.persist(bankAdmin);
		entityTransaction.commit();
		
		return bankAdmin;
	}
	
	public BankAdmin getAdminById(int id) {
	BankAdmin bankAdmin = entityManager.find(BankAdmin.class, id);
	if(id==bankAdmin.getAdminId()) {
	return bankAdmin;
	}else {
		System.out.println("Invalid Admin");
		return null;
	}
	}
	
	
	public void viewAllUnapprovedManager(int adminId){
		BankAdmin bankAdmin=entityManager.find(BankAdmin.class, adminId);
		BankManagerService bankManagerService=new BankManagerService();
	    List<BankManager> bankManagers = bankManagerService.getAllManager();
	    bankAdmin.setBankMangers(bankManagers);
		for(BankManager bM:bankManagers) {
			if(bM.getStatus().compareToIgnoreCase("Unapproved")==0) {
				bM.setStatus("Approved");
				bM.setBankAdmin(bankAdmin);
				BankManager bankManager= bankManagerService.updateManagerStatus(bM.getManagerId(), bM.getStatus());
				if(bankManager!=null) {
					System.out.println("Manager is approved");
				}
			}
				
			}
		}
	
	
	public BankAdmin updateBankAdmin(BankAdmin bankAdmin) {
		entityTransaction.begin();
		entityManager.merge(bankAdmin);
		entityTransaction.commit();
		return bankAdmin;
	}
	
	public boolean deleteAdminById(int id) {
		BankAdmin bankAdmin = entityManager.find(BankAdmin.class, id);
		entityTransaction.begin();
		entityManager.remove(bankAdmin);
		entityTransaction.commit();
		return true;
	}

	public List<BankAdmin> getAllAdmins() {
		String sql="select s from BankAdmin s";
		Query query = entityManager.createNamedQuery(sql);
		List<BankAdmin> bankAdmins = query.getResultList();
		return bankAdmins;
	}

}
