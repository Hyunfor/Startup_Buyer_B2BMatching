package com.b2b.domain;

public class ProductIMGVO {
	
	private int pimageNo;
	private int pno;
	private String imgName;
	private String fileLocation;
	
	public int getPimageNo() {
		return pimageNo;
	}
	public void setPimageNo(int pimageNo) {
		this.pimageNo = pimageNo;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public String getFileLocation() {
		return fileLocation;
	}
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	@Override
	public String toString() {
		return "ProductIMGVO [pimageNo=" + pimageNo + ", pno=" + pno + ", imgName=" + imgName + ", fileLocation="
				+ fileLocation + "]";
	}
	
}
