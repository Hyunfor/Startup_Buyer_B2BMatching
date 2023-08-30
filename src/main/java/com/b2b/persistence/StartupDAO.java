package com.b2b.persistence;

import java.util.List;

import com.b2b.domain.SearchCriteria;
import com.b2b.domain.StartupFileVO;
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
	
	
		// 7. 파일 등록
		public void insertFile(StartupFileVO fVo) throws Exception;

		// 8. 파일 삭제
		public void deleteFile(String startupId) throws Exception;

		// 9. 파일 목록
		public List<StartupFileVO> fileList(String startupId) throws Exception;
	
	

}
