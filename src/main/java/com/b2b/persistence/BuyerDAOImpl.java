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
	public BuyerVO read(int buyer_id) throws Exception {
		return session.selectOne(namespace + ".read", buyer_id);
	}

	@Override
	public void update(BuyerVO vo) throws Exception {
		session.update(namespace + ".update", vo);

	}

	@Override
	public void delete(int buyer_id) throws Exception {
		session.delete(namespace + ".delete", buyer_id);

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


}
