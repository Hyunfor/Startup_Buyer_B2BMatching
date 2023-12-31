package com.b2b.service;

import java.util.List;

import com.b2b.domain.BuyerVO;
import com.b2b.domain.SearchCriteria;

public interface BuyerService {
	
	public void register(BuyerVO vo) throws Exception;

	public BuyerVO read(int buyerId) throws Exception;
	
	public BuyerVO readPage(int buyerId) throws Exception;

	public void modify(BuyerVO vo) throws Exception;

	public void remove(int buyerId) throws Exception;

	public List<BuyerVO> listSearch(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;
}
