package com.b2b.persistence;



import java.util.List;

import com.b2b.domain.SearchCriteria;
import com.b2b.domain.StartupVO;

public interface StartupDAO {

	public void create(StartupVO vo) throws Exception;

	public StartupVO read(String startupId) throws Exception;

	public void update(StartupVO vo) throws Exception;

	public void delete(String startupId) throws Exception;

	public List<StartupVO> list();

	// �˻���� + ����¡ ���
	public List<StartupVO> listSearchCriteria(SearchCriteria cri) throws Exception;

	public int listSearchCountCriteria(SearchCriteria cri) throws Exception;
	
	
		
	

}
