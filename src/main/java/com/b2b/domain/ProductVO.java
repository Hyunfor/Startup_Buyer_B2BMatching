package com.b2b.domain;

import java.util.Date;

public class ProductVO {
	
	private int pno;
	private String pname;
	private String content;
	private Date regdate;
	private String startUp_Id;
	
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
	public String getStartUp_Id() {
		return startUp_Id;
	}
	public void setStartUp_Id(String startUp_Id) {
		this.startUp_Id = startUp_Id;
	}
	
	@Override
	public String toString() {
		return "ProductVO [pno=" + pno + ", pname=" + pname + ", content=" + content + ", regdate=" + regdate
				+ ", startUp_Id=" + startUp_Id + "]";
	}

}
