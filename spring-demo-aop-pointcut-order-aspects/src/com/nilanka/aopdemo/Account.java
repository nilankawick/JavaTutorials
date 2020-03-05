package com.nilanka.aopdemo;

public class Account {
	
	private String name;
	private int level;
	
	public Account() {
		System.out.println(getClass() +":Inside the Account() No Args Constructor\n ");
	}
	
	public Account(String name, int level) {
		//super();
		this.name = name;
		this.level = level;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	
	

}
