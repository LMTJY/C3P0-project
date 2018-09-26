package com.lmt.domain;

import java.util.Date;

public class Account {
	private int id;
	private int deal_type;
	private int pet_id;
	private int seller_id;
	private int buyer_id;
	private int price;
	private Date deal_time;
	@Override
	public String toString() {
		return "Account [id=" + id + ", deal_type=" + deal_type + ", pet_id=" + pet_id + ", seller_id=" + seller_id
				+ ", buyer_id=" + buyer_id + ", price=" + price + ", deal_time=" + deal_time + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDeal_type() {
		return deal_type;
	}
	public void setDeal_type(int deal_type) {
		this.deal_type = deal_type;
	}
	public int getPet_id() {
		return pet_id;
	}
	public void setPet_id(int pet_id) {
		this.pet_id = pet_id;
	}
	public int getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}
	public int getBuyer_id() {
		return buyer_id;
	}
	public void setBuyer_id(int buyer_id) {
		this.buyer_id = buyer_id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getDeal_time() {
		return deal_time;
	}
	public void setDeal_time(Date deal_time) {
		this.deal_time = deal_time;
	}
	
}
