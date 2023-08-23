package com.b2b.domain;

public class ProductIMGVO {
	
	private int pimage_no;
	private int pno;
	private String img_name;
	private String fileLocation;
	
	public int getPimage_no() {
		return pimage_no;
	}
	public void setPimage_no(int pimage_no) {
		this.pimage_no = pimage_no;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getImg_name() {
		return img_name;
	}
	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}
	public String getFileLocation() {
		return fileLocation;
	}
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	
	@Override
	public String toString() {
		return "ProductIMGVO [pimage_no=" + pimage_no + ", pno=" + pno + ", img_name=" + img_name + ", fileLocation="
				+ fileLocation + "]";
	}
	
}
