package com.b2b.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.b2b.domain.SearchCriteria;
import com.b2b.domain.StartupVO;
import com.b2b.persistence.StartupDAO;

@Service
public class StartupServiceImpl implements StartupService  {
	
	@Inject
	private StartupDAO dao;
	
	

	@Override
	public void register(StartupVO vo) throws Exception {
		dao.create(vo);
		
	}

	@Override
	public StartupVO read(String startup_id) throws Exception {
	
		return dao.read(startup_id);
	}

	@Override
	public void modify(StartupVO vo) throws Exception {
		
		dao.update(vo);
		
	}

	@Override
	public void remove(String startup_id) throws Exception {
		
		dao.delete(startup_id);
	
		
	}

	@Override
	public List<StartupVO> list() throws Exception {
	
		return  dao.list();
	}

	@Override
	public List<StartupVO> listSearchCriteria(SearchCriteria cri) throws Exception {
	
		return dao.listSearchCriteria(cri);
	}

	@Override
	public int listSearchCountCriteria(SearchCriteria cri) throws Exception {
		
		return dao.listSearchCountCriteria(cri);
	}
	
	

}
