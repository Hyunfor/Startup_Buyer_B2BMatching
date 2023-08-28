package com.b2b.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.b2b.domain.BuyerUserVO;
import com.b2b.dto.BuyerLoginDTO;
import com.b2b.persistence.BuyerUserDAO;

@Service
public class BuyerUserServiceImpl implements BuyerUserService {

	@Inject
	private BuyerUserDAO dao;

	@Override
	public BuyerUserVO login(BuyerLoginDTO dto) throws Exception {
		return dao.login(dto);
	}

	@Override
	public void register(BuyerUserVO vo) throws Exception {
		dao.create(vo);

	}

	@Override
	public BuyerUserVO read(String bId) throws Exception {
		return dao.read(bId);
	}

	@Override
	public void modify(BuyerUserVO vo) throws Exception {
		dao.update(vo);

	}

}
