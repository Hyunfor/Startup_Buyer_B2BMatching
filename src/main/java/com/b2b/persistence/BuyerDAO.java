package com.b2b.persistence;

import java.util.List;

import com.b2b.domain.BuyerVO;
import com.b2b.domain.SearchCriteria;

public interface BuyerDAO {

	public void create(BuyerVO vo) throws Exception;

	public BuyerVO read(int buyer_id) throws Exception;

	public void update(BuyerVO vo) throws Exception;

	public void delete(int buyer_id) throws Exception;

	public List<BuyerVO> list() throws Exception;

	public List<BuyerVO> listSearch(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;

	

	
}