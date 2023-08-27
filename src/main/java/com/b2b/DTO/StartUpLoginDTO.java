package com.b2b.DTO;

public class StartUpLoginDTO {

	private String s_id;
	private String s_pw;
	private boolean useCookie;

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}

	public String getS_pw() {
		return s_pw;
	}

	public void setS_pw(String s_pw) {
		this.s_pw = s_pw;
	}

	public boolean isUseCookie() {
		return useCookie;
	}

	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}

	@Override
	public String toString() {
		return "LoginDTO [s_id=" + s_id + ", s_pw=" + s_pw + ", useCookie=" + useCookie + "]";
	}

}
