package com.b2b.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.b2b.DTO.LoginDTO;
import com.b2b.domain.UserVO;


@Repository
public class UserDAOImpl implements UserDAO {

	@Inject
	private SqlSession session;

	private static final String namespace = "com.b2b.mapper.UserMapper";

	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".login", dto);
	}

	@Override
	public void create(UserVO vo) throws Exception {
		session.insert(namespace + ".create", vo);

	}

	@Override
	public UserVO read(String usid) throws Exception {
		return session.selectOne(namespace + ".read", usid);
	}

	@Override
	public void update(UserVO vo) throws Exception {
		session.update(namespace + ".update", vo);

	}

	@Override
	public void delete(String usid) throws Exception {
		session.delete(namespace + ".delete", usid);

	}

}
