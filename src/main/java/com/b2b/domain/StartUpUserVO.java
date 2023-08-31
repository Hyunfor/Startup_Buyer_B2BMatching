package com.b2b.domain;

public class StartUpUserVO {

	private String sName;
	private String sId;
	private String sPw;
	private String name;
	private String startupId;
	
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsId() {
		return sId;
	}
	public void setsId(String sId) {
		this.sId = sId;
	}
	public String getsPw() {
		return sPw;
	}
	public void setsPw(String sPw) {
		this.sPw = sPw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartupId() {
		return startupId;
	}
	public void setStartupId(String startupId) {
		this.startupId = startupId;
	}
	@Override
	public String toString() {
		return "StartUpUserVO [sName=" + sName + ", sId=" + sId + ", sPw=" + sPw + ", name=" + name + ", startupId="
				+ startupId + "]";
	}
	

	
	
}