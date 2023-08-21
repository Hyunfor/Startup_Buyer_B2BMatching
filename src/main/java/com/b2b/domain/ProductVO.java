package com.b2b.domain;

import java.util.Date;

public class ProductVO {
	
	private int pno;
	private String pname;
<<<<<<< HEAD
	private String category;
=======
>>>>>>> 69ae2dab15be6704ae55bfd218fdc0602e971f98
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
<<<<<<< HEAD
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
=======
>>>>>>> 69ae2dab15be6704ae55bfd218fdc0602e971f98
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
<<<<<<< HEAD
		return "ProductVO [pno=" + pno + ", pname=" + pname + ", category=" + category + ", content=" + content
				+ ", regdate=" + regdate + ", startUp_Id=" + startUp_Id + "]";
	}

}
=======
		return "ProductVO [pno=" + pno + ", pname=" + pname + ", content=" + content + ", regdate=" + regdate
				+ ", startUp_Id=" + startUp_Id + "]";
	}

}
>>>>>>> 69ae2dab15be6704ae55bfd218fdc0602e971f98
