package com.b2b.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.b2b.domain.BuyerUserVO;
import com.b2b.dto.BuyerLoginDTO;

@Repository
public class BuyerUserDAOImpl implements BuyerUserDAO {

	@Inject
	private SqlSession session;

	private static final String namespace = "com.b2b.mapper.BuyerUserMapper";

	@Override
	public BuyerUserVO login(BuyerLoginDTO dto) throws Exception {
		return session.selectOne(namespace + ".login", dto);
	}

	@Override
	public void create(BuyerUserVO vo) throws Exception {
		session.insert(namespace + ".create", vo);

	}

	@Override
	public BuyerUserVO read(String b_id) throws Exception {
		return session.selectOne(namespace + ".read", b_id);
	}

	@Override
	public void update(BuyerUserVO vo) throws Exception {
		session.update(namespace + ".update", vo);

	}

}
