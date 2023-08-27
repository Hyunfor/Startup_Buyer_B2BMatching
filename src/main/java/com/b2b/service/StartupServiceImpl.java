package com.b2b.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.b2b.domain.SearchCriteria;
import com.b2b.domain.StartupVO;
import com.b2b.persistence.StartupDAO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class StartupServiceImpl implements StartupService  {
	
	@Inject
	private StartupDAO dao;
	
	

	@Override
	public void register(StartupVO vo) throws Exception {
		dao.create(vo);
		
	}

	@Override
	public StartupVO read(String startupId) throws Exception {
	
		return dao.read(startupId);
	}

	@Override
	public void modify(StartupVO vo) throws Exception {
		
		dao.update(vo);
		
	}

	@Override
	public void remove(String startupId) throws Exception {
		
		dao.delete(startupId);
	
		
	}

	/*@Override
	public List<StartupVO> list() throws Exception {
	
		return  dao.list();
	}*/

	@Override
	public List<StartupVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		
	
		return dao.listSearchCriteria(cri);
	}

	@Override
	public int listSearchCountCriteria(SearchCriteria cri) throws Exception {
		
		return dao.listSearchCountCriteria(cri);
	}
	
	

}
