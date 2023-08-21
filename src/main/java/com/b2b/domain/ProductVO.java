package com.b2b.domain;

import java.util.Date;

public class ProductVO {
	
	private int pno;
	private String pname;
	private String category;
	private String content;
	private Date regdate;
	private String startup_id;
	
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getstartup_id() {
		return startup_id;
	}
	public void setstartup_id(String startup_id) {
		this.startup_id = startup_id;
	}
	
	@Override
	public String toString() {

		return "ProductVO [pno=" + pno + ", pname=" + pname + ", category=" + category + ", content=" + content
				+ ", regdate=" + regdate + ", startup_id=" + startup_id + "]";
	}

}
