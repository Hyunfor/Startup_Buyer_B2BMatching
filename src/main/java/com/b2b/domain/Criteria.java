package com.b2b.domain;

public class Criteria {
	
	private int page; // ���� ������
	private int perPageNum; // ȭ�鿡 ������ ������ ��
	
	private int startPage; // MyBatis���� ����� ���� ������ ����
	
	// �ʱⵥ���� ������ ���� ������ - > 1������ ����, ������ �������� 10��������  
	public Criteria() {
		
		this.page = 1;
		this.perPageNum = 10;
		
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		
		// ����¡�� ���� ����ó��
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
	
	// MyBatis���� ����� method
	public int getPageEnd() {
		
		// �����ϴ� �������� + 9�� �ؼ� ����¡�ÿ� �����ֱ�
		return this.startPage + 9;
		
	}
	
	public int getPageStart() {
		
		// ����¡ ���� row ��� - > 1page-> 1row, 2page-> 11row, 3page -> 21row, 4page - > 31page ...
		this.startPage = (this.page * this.perPageNum) - 9;
		
		return this.startPage;
		
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", startPage=" + startPage + ", getPageEnd()="
				+ getPageEnd() + ", getPageStart()=" + getPageStart() + "]";
	}
	
}
