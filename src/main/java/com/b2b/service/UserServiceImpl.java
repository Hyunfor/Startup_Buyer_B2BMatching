package com.mis.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mis.domain.UserVO;
import com.mis.dto.LoginDTO;
import com.mis.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	private UserDAO dao;

	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return dao.login(dto);
	}

	@Override
	public void register(UserVO vo) throws Exception {
		dao.create(vo);

	}

	@Override
	public UserVO read(String usid) throws Exception {
		return dao.read(usid);
	}

	@Override
	public void modify(UserVO vo) throws Exception {
		dao.update(vo);

	}

	@Override
	public void remove(String usid) throws Exception {
		dao.delete(usid);

	}

}
