package com.b2b.persistence;

import java.util.List;

import com.b2b.domain.ProductIMGVO;
import com.b2b.domain.ProductVO;
import com.b2b.domain.SearchCriteria;

public interface ProductDAO {

	// ��� - �Խñۿ� �Ҽӵ� ÷������ ����� ���� int(noticeNo) ����)
	public int adCreate(ProductVO vo) throws Exception;

	// �Ϲ� ���� ���� - �󼼺���
	public ProductVO read(int pno) throws Exception;

	// ��ŸƮ�� ���� - �󼼺���
	public ProductVO readPage(int startUpId) throws Exception;

	// ���� - ��� �����Ȱ��� Ȯ�� �Ұ���. ��ü �Խñ��� �� ����� ���� ��Ͻ�Ŵ.
	public void adUpdate(ProductVO vo) throws Exception;

	public void adDelete(int pno) throws Exception;

	// �˻� ������ ���
	public List<ProductVO> listSearch(SearchCriteria cri) throws Exception;

	// �˻� ������ ��� - ����¡, ī��Ʈ
	public int listSearchCount(SearchCriteria cri) throws Exception;

	// 1. ���� ���
	public void insertFile(ProductIMGVO fVo) throws Exception;

	// 2. ���� ����
	public void deleteFile(int pno) throws Exception;

	// 3. ���� ���
	public List<ProductIMGVO> fileList(int pno) throws Exception;

	// ��ŸƮ�� ������ ���������� ����
	public List<ProductVO> adminList() throws Exception;

}