package com.b2b.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {

	// 페이징을 위한 게시글 데이터 처리 - > Criteria
	// 화면에 페이징 정보 처리 - > PageMaker

	private int totalCount; // 게시글 전체 수
	private int startPage;
	private int endPage;
	private boolean prev; // 이전 페이지 유무
	private boolean next; // 다음 페이지 유무

	private int displayPageNum = 10; // 화면에 페이지 링크(페이지 네비게이터)

	private Criteria cri;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;

		// 전체 게시글 수가 설정되면 페이징을 계산
		calcData();
	}

	private void calcData() {

		// 1) 페이징 버튼 시작과 끝
		endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);
		startPage = (endPage - displayPageNum) + 1;

		// 2) 페이지 버튼이 10개 이상인 경우
		int tempEndPage = (int) Math.ceil(totalCount / (double) cri.getPerPageNum());

		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}

		// 3) prev, next 버튼 계산
		prev = startPage == 1 ? false : true;
		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;

	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	// 페이징 버튼에서 사용할 이동 링크(QuerySrting) 만들기 - > jsp에서 직접 호출
	public String makeQuery(int page) {

		UriComponents uricomponents = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", cri.getPerPageNum())
				.build();

		return uricomponents.toUriString();

	}

	// 페이징 버튼에서 사용할 이동 링크(QuerySrting)+ 검색(SearchType, keyword) 만들기 - > jsp에서 직접 호출
	public String makeSearch(int page) {

		UriComponents uricomponents = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", cri.getPerPageNum())
				.queryParam("searchType", ((SearchCriteria)cri).getSearchType()) // SerchCriteria로 형변환 후 상속
				.queryParam("keyword", ((SearchCriteria)cri).getKeyword())
				.build();

		return uricomponents.toUriString();

	}

}
