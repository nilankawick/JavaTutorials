package com.nilanka.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	/*
	public void addAccount(){
		System.out.println(getClass() +":MemberShip DAO ====> DOING MY DB WORK: ADDING AN ACCOUNT\n");
	}
	*/

	public boolean addSillyAccount(){
		System.out.println(getClass() +"MemberShip DAO ===> (addSillyAccount() - DOING MY DB WORK: ADDING AN MEMBERSHIP WITHOUT PARAMETERS\n");
		
		return true;
	}
	
	public void goToSleep(){
		System.out.println(getClass() +"MemberShip DAO [goToSleep()] ===> :I am going to Sleep\n");
		
}
}
