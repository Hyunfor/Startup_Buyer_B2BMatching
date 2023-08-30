package com.b2b.domain;

public class StartupFileVO {
	
	
	private int startupFileNo;
	private String startupId;
	private String startupFileName;//파일 네임만
	private String fileLocation; //파일의 들어있는 풀네임 정보
	
	public int getStartupFileNo() {
		return startupFileNo;
	}
	public void setStartupFileNo(int startupFileNo) {
		this.startupFileNo = startupFileNo;
	}
	public String getStartupId() {
		return startupId;
	}
	public void setStartupId(String startupId) {
		this.startupId = startupId;
	}
	public String getStartupFileName() {
		return startupFileName;
	}
	public void setStartupFileName(String startupFileName) {
		this.startupFileName = startupFileName;
	}
	public String getFileLocation() {
		return fileLocation;
	}
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	@Override
	public String toString() {
		return "StartupFileVO [startupFileNo=" + startupFileNo + ", startupId=" + startupId + ", startupFileName="
				+ startupFileName + ", fileLocation=" + fileLocation + "]";
	}
	
	
	
	
	

}
