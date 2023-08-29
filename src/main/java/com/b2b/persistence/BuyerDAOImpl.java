package com.b2b.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.b2b.domain.BuyerVO;
import com.b2b.domain.SearchCriteria;

@Repository
public class BuyerDAOImpl implements BuyerDAO {

	@Inject
	private SqlSession session;

	private static final String namespace = "com.b2b.mapper.BuyerMapper";

	@Override
	public void create(BuyerVO vo) throws Exception {
		session.insert(namespace + ".create", vo);

	}

	@Override
	public BuyerVO read(int buyerId) throws Exception {
		return session.selectOne(namespace + ".read", buyerId);
	}

	@Override
	public void update(BuyerVO vo) throws Exception {
		session.update(namespace + ".update", vo);

	}

	@Override
	public void delete(int buyerId) throws Exception {
		session.delete(namespace + ".delete", buyerId);

	}

	@Override
	public List<BuyerVO> list() throws Exception {
		return session.selectList(namespace + ".list");
	}

	@Override
	public List<BuyerVO> listSearch(SearchCriteria cri) throws Exception {
		return session.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".listSearchCount", cri);
	}

	@Override
	public List<BuyerVO> adminList() throws Exception {
		return session.selectList(namespace + ".adminList");
	}


}
