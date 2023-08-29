package com.b2b.domain;

import java.util.Date;

public class CommentsVO {
	
	private int commentNo;
    private int pno;
    private String id;
    private String name;
    private String comments;
    private Date regdate;
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "CommentsVO [commentNo=" + commentNo + ", pno=" + pno + ", id=" + id + ", name=" + name + ", comments="
				+ comments + ", regdate=" + regdate + "]";
	}
    

}
