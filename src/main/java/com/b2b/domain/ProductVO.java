package com.b2b.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class ProductVO {
	
	private int pno;
	private String pname;
	private String category;
	private String content;
	private Date regdate;
	private String startupId;
	private String[] files;
	//상세보기 file 여러개 가져오기
	private ArrayList<ProductIMGVO> fileList;
	
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
	public String getStartupId() {
		return startupId;
	}
	public void setStartupId(String startupId) {
		this.startupId = startupId;
	}
	public String[] getFiles() {
		return files;
	}
	public void setFiles(String[] files) {
		this.files = files;
	}
	public ArrayList<ProductIMGVO> getFileList() {
		return fileList;
	}
	public void setFileList(ArrayList<ProductIMGVO> fileList) {
		this.fileList = fileList;
	}
	@Override
	public String toString() {
		return "ProductVO [pno=" + pno + ", pname=" + pname + ", category=" + category + ", content=" + content
				+ ", regdate=" + regdate + ", startupId=" + startupId + ", files=" + Arrays.toString(files)
				+ ", fileList=" + fileList + "]";
	}
	
}