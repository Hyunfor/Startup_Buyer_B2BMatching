package com.b2b.DTO;

public class LoginDTO {

	private String usid;
	private String upw;
	private boolean useCookie;

	public String getUsid() {
		return usid;
	}

	public void setUsid(String usid) {
		this.usid = usid;
	}

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	public boolean isUseCookie() {
		return useCookie;
	}

	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}

	@Override
	public String toString() {
		return "LoginDTO [usid=" + usid + ", upw=" + upw + ", useCookie=" + useCookie + "]";
	}

}
