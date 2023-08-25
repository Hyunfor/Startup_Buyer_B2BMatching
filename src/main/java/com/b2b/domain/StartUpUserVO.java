package com.b2b.domain;

public class StartUpUserVO {

	private String s_name;
	private String s_id;
	private String s_pw;

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

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

	@Override
	public String toString() {
		return "StartUpUserVO [s_name=" + s_name + ", s_id=" + s_id + ", s_pw=" + s_pw + "]";
	}

}