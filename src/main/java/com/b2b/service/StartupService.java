package com.b2b.service;

import java.util.List;

import com.b2b.domain.SearchCriteria;
import com.b2b.domain.StartupFileVO;
import com.b2b.domain.StartupVO;

public interface StartupService {
	
	public void register(StartupVO vo) throws Exception;

	public StartupVO read(String startupId) throws Exception;

	public void modify(StartupVO vo) throws Exception;

	public void remove(String startupId) throws Exception;

	//public List<StartupVO> list() throws Exception;
	
	public List<StartupVO> listSearchCriteria(SearchCriteria cri) throws Exception;
	
	public int listSearchCountCriteria(SearchCriteria cri) throws Exception;
	
	// 7. 관리자 :: 파일 목록
		public List<StartupFileVO> fileList(String startupId) throws Exception;


}
