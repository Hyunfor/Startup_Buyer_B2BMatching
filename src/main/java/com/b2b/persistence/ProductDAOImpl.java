package com.b2b.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.b2b.domain.ProductVO;
import com.b2b.domain.SearchCriteria;

@Repository
public class ProductDAOImpl implements ProductDAO{
	
	@Inject
	private SqlSession session;
	
	private static final String namespace = "com.b2b.mapper.ProductMapper";

	@Override
	public void create(ProductVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
	}

	@Override
	public ProductVO read(int pno) throws Exception {
		return session.selectOne(namespace + ".read", pno);
	}

	@Override
	public void update(ProductVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(int pno) throws Exception {
		session.delete(namespace + ".delete", pno);	
	}
	
	@Override
	public List<ProductVO> listSearch(SearchCriteria cri) throws Exception {
		return session.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".listSearchCount", cri);
	}
	
}
