package com.b2b.domain;

import java.util.Date;

public class BuyerVO {

	private int buyerId;
	private String buyerName;
	private String email;
	private String country;
	private String category;
	private String business;
	private String items;
	private String orderAmount;
	private Date regdate;

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public String getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "BuyerVO [buyerId=" + buyerId + ", buyerName=" + buyerName + ", email=" + email + ", country=" + country
				+ ", category=" + category + ", business=" + business + ", items=" + items + ", orderAmount="
				+ orderAmount + ", regdate=" + regdate + "]";
	}
	
}
