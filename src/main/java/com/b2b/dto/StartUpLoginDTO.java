package com.b2b.dto;

public class StartUpLoginDTO {

	private String sId;
	private String sPw;
	
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
	@Override
	public String toString() {
		return "StartUpLoginDTO [sId=" + sId + ", sPw=" + sPw + "]";
	}
	
	

}
