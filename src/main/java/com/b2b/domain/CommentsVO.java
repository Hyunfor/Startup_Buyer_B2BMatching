package com.b2b.domain;

import java.util.Date;

public class CommentsVO {
	
	private int commentNo;
    private int pno;
    private String startupId;
    private String buyerId;
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
	public String getStartupId() {
		return startupId;
	}
	public void setStartupId(String startupId) {
		this.startupId = startupId;
	}
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
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
		return "CommentsVO [commentNo=" + commentNo + ", pno=" + pno + ", startupId=" + startupId + ", buyerId="
				+ buyerId + ", comments=" + comments + ", regdate=" + regdate + "]";
	}
    
}
