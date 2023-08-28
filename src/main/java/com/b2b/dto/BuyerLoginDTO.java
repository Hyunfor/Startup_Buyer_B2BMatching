package com.b2b.dto;

public class BuyerLoginDTO {

	private String bId;
	private String bPw;

	public String getbId() {
		return bId;
	}

	public void setbId(String bId) {
		this.bId = bId;
	}

	public String getbPw() {
		return bPw;
	}

	public void setbPw(String bPw) {
		this.bPw = bPw;
	}

	@Override
	public String toString() {
		return "BuyerLoginDTO [bId=" + bId + ", bPw=" + bPw + "]";
	}

}
