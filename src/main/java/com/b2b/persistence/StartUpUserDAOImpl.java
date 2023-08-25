package com.b2b.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.b2b.DTO.StartUpLoginDTO;
import com.b2b.domain.StartUpUserVO;

@Repository
public class StartUpUserDAOImpl implements StartUpUserDAO {

	@Inject
	private SqlSession session;

	private static final String namespace = "com.b2b.mapper.StartUpUserMapper";

	@Override
	public StartUpUserVO login(StartUpLoginDTO dto) throws Exception {
		return session.selectOne(namespace + ".login", dto);
	}

	@Override
	public void create(StartUpUserVO vo) throws Exception {
		session.insert(namespace + ".create", vo);

	}

	@Override
	public StartUpUserVO read(String usid) throws Exception {
		return session.selectOne(namespace + ".read", usid);
	}

	@Override
	public void update(StartUpUserVO vo) throws Exception {
		session.update(namespace + ".update", vo);

	}

}
