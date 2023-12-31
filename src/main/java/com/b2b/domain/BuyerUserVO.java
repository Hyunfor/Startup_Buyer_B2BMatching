package com.b2b.domain;

public class BuyerUserVO {

	private String bName;
	private String bId;
	private String bPw;
	private String name;
	private int buyerId;

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}

	@Override
	public String toString() {
		return "BuyerUserVO [bName=" + bName + ", bId=" + bId + ", bPw=" + bPw + ", name=" + name + ", buyerId="
				+ buyerId + "]";
	}

}
