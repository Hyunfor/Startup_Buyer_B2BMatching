package com.b2b.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.b2b.domain.UserVO;
import com.b2b.dto.LoginDTO;
import com.b2b.persistence.UserDAO;

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
