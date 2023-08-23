package com.b2b.persistence;

import java.util.List;

import com.b2b.domain.SearchCriteria;
import com.b2b.domain.StartupVO;

public interface StartupDAO {

	public void create(StartupVO vo) throws Exception;

	public StartupVO read(String startup_id) throws Exception;

	public void update(StartupVO vo) throws Exception;

	public void delete(String startup_id) throws Exception;

	public List<StartupVO> list();

	// 검색기능 + 페이징 기능
	public List<StartupVO> listSearchCriteria(SearchCriteria cri) throws Exception;

	public int listSearchCountCriteria(SearchCriteria cri) throws Exception;

}
