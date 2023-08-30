package com.b2b.service;

import java.util.List;

import com.b2b.domain.ProductIMGVO;
import com.b2b.domain.ProductVO;
import com.b2b.domain.SearchCriteria;

public interface ProductService {

	public void register(ProductVO vo) throws Exception;

	// 일반 유저 입장 - 상세보기
	public ProductVO read(int pno) throws Exception;
	
	// 스타트업 관리자 페이지 입장 - 상세보기
	public ProductVO readPage(int startUpId) throws Exception;

	public void modify(ProductVO vo) throws Exception;

	public void remove(int pno) throws Exception;

	// 검색 가능한 목록
	public List<ProductVO> listSearch(SearchCriteria cri) throws Exception;

	// 검색 가능한 목록 ---> 페이징 , 카운트
	public int listSearchCount(SearchCriteria cri) throws Exception;

	// 파일 목록
	public List<ProductIMGVO> fileList(int pno) throws Exception;

}