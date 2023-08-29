package com.b2b.service;

import java.util.List;

import com.b2b.domain.ProductIMGVO;
import com.b2b.domain.ProductVO;
import com.b2b.domain.SearchCriteria;

public interface ProductService {

	public void register(ProductVO vo) throws Exception;

	public ProductVO read(int pno) throws Exception;

	public void modify(ProductVO vo) throws Exception;

	public void remove(int pno) throws Exception;

	// �˻� ������ ���
	public List<ProductVO> listSearch(SearchCriteria cri) throws Exception;

	// �˻� ������ ��� ---> ����¡ , ī��Ʈ
	public int listSearchCount(SearchCriteria cri) throws Exception;

	// ���� ���
	public List<ProductIMGVO> fileList(int pno) throws Exception;

}