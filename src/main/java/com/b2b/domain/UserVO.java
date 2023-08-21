package com.mis.domain;

public class UserVO {

	private String uname;
	private String usid;
	private String upw;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
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
	@Override
	public String toString() {
		return "UserVO [uname=" + uname + ", usid=" + usid + ", upw=" + upw + "]";
	}

}
