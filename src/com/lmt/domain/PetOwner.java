package com.lmt.domain;

public class PetOwner {
	private int id;
	private String name;
	private String passWord;
	private int money;
	@Override
	public String toString() {
		return "PetOwner [id=" + id + ", name=" + name + ", passWord=" + passWord + ", money=" + money + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
}
