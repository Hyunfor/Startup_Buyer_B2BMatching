package com.b2b.service;

import java.util.List;

import com.b2b.domain.ProductVO;
import com.b2b.domain.SearchCriteria;


public interface ProductService {

	public void register(ProductVO vo) throws Exception;

	public ProductVO read(int pno) throws Exception;

	public void modify(ProductVO vo) throws Exception;

	public void remove(int pno) throws Exception;

	// 페이징, 검색 기능을 제공하는 list 가져오는 기능
	public List<ProductVO> listSearch(SearchCriteria cri) throws Exception;

	// 페이징, 검색 기능 게시물 수 가져오는 기능
	public int listSearchCount(SearchCriteria cri) throws Exception;
	

}
