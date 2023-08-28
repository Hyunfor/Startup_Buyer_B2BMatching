package com.b2b.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.b2b.domain.StartUpUserVO;
import com.b2b.dto.StartUpLoginDTO;

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
	public StartUpUserVO read(String sId) throws Exception {
		return session.selectOne(namespace + ".read", sId);
	}

	@Override
	public void update(StartUpUserVO vo) throws Exception {
		session.update(namespace + ".update", vo);

	}

}
