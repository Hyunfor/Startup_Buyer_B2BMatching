package com.b2b.domain;

public class Criteria {
	
	private int page; // 시작 페이지
	private int perPageNum; // 화면에 보여줄 페이지 수
	
	private int startPage; // MyBatis에서 사용할 시작 페이지 정보
	
	// 초기데이터 설정을 위한 생성자 - > 1페이지 부터, 보여줄 페이지는 10페이지씩 
	public Criteria() {
		
		this.page = 1;
		this.perPageNum = 10;
		
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		
		// 페이징에 대한 예외처리
		if(page <= 0) {
			this.page = 1;
			return;
		}
		
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	
	// MyBatis에서 사용할 method
	public int getPageEnd() {
		
		// 시작하는 페이지에 + 9를 해서 페이징시에 맞춰주기
		return this.startPage + 9;
		
	}
	
	public int getPageStart() {
		
		// 페이징 시작 row 계산 - > 1page-> 1row, 2page-> 11row, 3page -> 21row, 4page - > 31page ...
		this.startPage = (this.page * this.perPageNum) - 9;
		
		return this.startPage;
		
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", startPage=" + startPage + ", getPageEnd()="
				+ getPageEnd() + ", getPageStart()=" + getPageStart() + "]";
	}
	
}
