package com.b2b.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.b2b.domain.StartUpUserVO;
import com.b2b.dto.StartUpLoginDTO;
import com.b2b.persistence.StartUpUserDAO;

@Service
public class StartUpUserServiceImpl implements StartUpUserService {

	@Inject
	private StartUpUserDAO dao;

	@Override
	public StartUpUserVO login(StartUpLoginDTO dto) throws Exception {
		return dao.login(dto);
	}

	@Override
	public void register(StartUpUserVO vo) throws Exception {
		dao.create(vo);

	}

	@Override
	public StartUpUserVO read(String sId) throws Exception {
		return dao.read(sId);
	}

	@Override
	public void modify(StartUpUserVO vo) throws Exception {
		dao.update(vo);

	}

}
