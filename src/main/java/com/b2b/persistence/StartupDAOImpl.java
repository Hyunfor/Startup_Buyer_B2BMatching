package com.b2b.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.b2b.domain.SearchCriteria;
import com.b2b.domain.StartupVO;

@Repository
public class StartupDAOImpl implements StartupDAO {
	
	@Inject
	private SqlSession session;
	
	private static final String namespace="com.b2b.mapper.StartupMapper";
	

	@Override
	public void create(StartupVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
		
	}

	@Override
	public StartupVO read(String startup_id) throws Exception {
		return session.selectOne(namespace + ".read",startup_id);
		
	}

	@Override
	public void update(StartupVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(String startup_id) throws Exception {
		session.delete(namespace + ".delete", startup_id);
		
	}


	@Override
	public List<StartupVO> list() {
		return session.selectList(namespace + ".list");
	}

	@Override
	public List<StartupVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return session.selectList(namespace + ".listSearchCriteria", cri);
	}

	@Override
	public int listSearchCountCriteria(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".listSearchCountCriteria", cri);
	}


}
