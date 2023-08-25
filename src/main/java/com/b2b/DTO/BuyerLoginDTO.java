package com.b2b.DTO;

public class BuyerLoginDTO {

	private String b_id;
	private String b_pw;
	private boolean useCookie;

	public String getB_id() {
		return b_id;
	}

	public void setB_id(String b_id) {
		this.b_id = b_id;
	}

	public String getB_pw() {
		return b_pw;
	}

	public void setB_pw(String b_pw) {
		this.b_pw = b_pw;
	}

	public boolean isUseCookie() {
		return useCookie;
	}

	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}

	@Override
	public String toString() {
		return "BuyerLoginDTO [b_id=" + b_id + ", b_pw=" + b_pw + ", useCookie=" + useCookie + "]";
	}

}
