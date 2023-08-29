package com.b2b.service;

import java.util.List;

import com.b2b.domain.ProductIMGVO;
import com.b2b.domain.ProductVO;
import com.b2b.domain.SearchCriteria;

public interface ProductService {

	public void register(ProductVO vo) throws Exception;

	public ProductVO read(int pno) throws Exception;

	public void modify(ProductVO vo) throws Exception;

	public void remove(int pno) throws Exception;

	// 검색 가능한 목록
	public List<ProductVO> listSearch(SearchCriteria cri) throws Exception;

	// 검색 가능한 목록 ---> 페이징 , 카운트
	public int listSearchCount(SearchCriteria cri) throws Exception;

	// 파일 목록
	public List<ProductIMGVO> fileList(int pno) throws Exception;

}