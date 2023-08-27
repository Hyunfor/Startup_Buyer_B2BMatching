package com.b2b.domain;

import java.util.Date;

import javax.xml.crypto.Data;

public class StartupVO {

	
	private String startupName;
	private String names;
	private String startupId;
	private String establishedYear;
	private String sizes;
	private String categorys;
	private String business;
	private String noOfEmployees;
	private String city;
	private String items;
	private String email;
	private Date regdate;
	public String getStartupName() {
		return startupName;
	}
	public void setStartupName(String startupName) {
		this.startupName = startupName;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String getStartupId() {
		return startupId;
	}
	public void setStartupId(String startupId) {
		this.startupId = startupId;
	}
	public String getEstablishedYear() {
		return establishedYear;
	}
	public void setEstablishedYear(String establishedYear) {
		this.establishedYear = establishedYear;
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
	public String getNoOfEmployees() {
		return noOfEmployees;
	}
	public void setNoOfEmployees(String noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
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
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "StartupVO [startupName=" + startupName + ", names=" + names + ", startupId=" + startupId
				+ ", establishedYear=" + establishedYear + ", sizes=" + sizes + ", categorys=" + categorys
				+ ", business=" + business + ", noOfEmployees=" + noOfEmployees + ", city=" + city + ", items=" + items
				+ ", email=" + email + ", regdate=" + regdate + "]";
	}
	
	
	
	
	
}
