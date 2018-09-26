package com.lmt.domain;

import java.util.Date;

public class Pet {
	private int id;
	private String name;
	private String typeName;
	private int health;
	private int love;
	private Date birthday;
	private int owner_id;
	private int store_id;
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
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getLove() {
		return love;
	}
	public void setLove(int love) {
		this.love = love;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", typeName=" + typeName + ", health=" + health + ", love=" + love
				+ ", birthday=" + birthday + ", owner_id=" + owner_id + ", store_id=" + store_id + "]";
	}

	
}
