package com.b2b.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.b2b.domain.SearchCriteria;
import com.b2b.domain.StartupFileVO;
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
	public StartupVO read(String startupdId) throws Exception {
		return session.selectOne(namespace + ".read",startupdId);
		
	}

	@Override
	public void update(StartupVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(String startupdId) throws Exception {
		session.delete(namespace + ".delete", startupdId);
		
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

	@Override
	public void insertFile(StartupFileVO fVo) throws Exception {
		session.insert(namespace + ".insertFile" ,fVo);
		
	}

	@Override
	public void deleteFile(String startupId) throws Exception {
		session.delete(namespace + ".deleteFile" ,startupId);
		
	}

	@Override
	public List<StartupFileVO> fileList(String startupId) throws Exception {
		
		return session.selectList(namespace +".fileList",startupId);
	}


}
