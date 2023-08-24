package com.b2b.domain;

import javax.xml.crypto.Data;

public class StartupVO {

	private String startup_id;
	private String startupName;
	private String established_Year;
	private String sizes;
	private String categorys;
	private String business;
	private String no_Of_Employees;
	private String city;
	private String items;
	private String email;
	private String names;
	private Data regdate;

	public String getStartup_id() {
		return startup_id;
	}

	public void setStartup_id(String startup_id) {
		this.startup_id = startup_id;
	}

	public String getStartupName() {
		return startupName;
	}

	public void setStartupName(String startupName) {
		this.startupName = startupName;
	}

	public String getEstablished_Year() {
		return established_Year;
	}

	public void setEstablished_Year(String established_Year) {
		this.established_Year = established_Year;
	}

	public String getSizes() {
		return sizes;
	}

	public void setSizes(String sizes) {
		this.sizes = sizes;
	}

	public String getCategorys() {
		return categorys;
	}

	public void setCategorys(String categorys) {
		this.categorys = categorys;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getNo_Of_Employees() {
		return no_Of_Employees;
	}

	public void setNo_Of_Employees(String no_Of_Employees) {
		this.no_Of_Employees = no_Of_Employees;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public Data getRegdate() {
		return regdate;
	}

	public void setRegdate(Data regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "StartupVO [startup_id=" + startup_id + ", startupName=" + startupName + ", established_Year="
				+ established_Year + ", sizes=" + sizes + ", categorys=" + categorys + ", business=" + business
				+ ", no_Of_Employees=" + no_Of_Employees + ", city=" + city + ", items=" + items + ", email=" + email
				+ ", names=" + names + ", regdate=" + regdate + "]";
	}

}
