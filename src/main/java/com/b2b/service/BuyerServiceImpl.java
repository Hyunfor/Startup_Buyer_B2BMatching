package com.b2b.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.b2b.domain.BuyerVO;
import com.b2b.domain.SearchCriteria;
import com.b2b.persistence.BuyerDAO;

@Service
public class BuyerServiceImpl implements BuyerService {

	@Inject
	private BuyerDAO dao;

	@Override
	public void register(BuyerVO vo) throws Exception {
		dao.create(vo);

	}

	@Override
	public BuyerVO read(int buyer_id) throws Exception {
		return dao.read(buyer_id);
	}

	@Override
	public void modify(BuyerVO vo) throws Exception {
		dao.update(vo);

	}

	@Override
	public void remove(int buyer_id) throws Exception {
		dao.delete(buyer_id);

	}

	@Override
	public List<BuyerVO> listSearch(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}

}
