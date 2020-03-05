package com.nilanka.aopdemo.dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nilanka.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String accountName;
	private String serviceName;
	private List<Account> tmpAccounts = new ArrayList<>();
	
	/**/
	public void addAccount(){
		System.out.println(getClass() +":Account DAO [addAccount()] ===> DOING MY DB WORK: ADDING AN ACCOUNT WITHOUT PARAMETERS\n");
	}
	
	
	public void addAccount(Account tmpAccount, boolean vipFlag ){
			System.out.println(getClass() +":Account DAO [addAccount(..)] ===> DOING MY DB WORK: ADDING AN ACCOUNT WITH A PARAMETER\n");
	}
	
	public boolean doWork(){
		System.out.println(getClass() +":Account DAO [doWork()] ===> doWork()\n");
		return false;
	}

	public String getAccountName() {
		System.out.println(getClass() +":Account DAO [getAccountName()] ===> get Account Name\n");
		return accountName;
		
	}

	public void setAccountName(String accountName) {
		System.out.println(getClass() +":Account DAO [setAccountName()] ===> set Account Name - " +accountName+"\n");
		this.accountName = accountName;
	}

	public String getServiceName() {
		System.out.println(getClass() +":Account DAO [getServiceName()] ===> get service Name \n");
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		System.out.println(getClass() +"::Account DAO [setServiceName()] ===> set service Name - "+serviceName+"\n");
		this.serviceName = serviceName;
	}
	
	public List<Account> findAccounts() {
		//List<Account> tmpAccounts = new ArrayList<>();
		
		System.out.println("\n DEBUG ==> "+getClass() +":Account DAO [findAccounts()]\n");
		
		//Create sample accounts
		Account tmp1 = new Account("John",2);
		Account tmp2 = new Account("Nilo",3);
		Account tmp3 = new Account("Lasen",1);
		
		//add them to the array list
		tmpAccounts.add(tmp1);
		tmpAccounts.add(tmp2);
		tmpAccounts.add(tmp3);
		
		return tmpAccounts;
		
	}
		
	
}
