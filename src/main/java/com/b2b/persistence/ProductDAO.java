package com.b2b.persistence;

import java.util.List;

import com.b2b.domain.ProductIMGVO;
import com.b2b.domain.ProductVO;
import com.b2b.domain.SearchCriteria;

public interface ProductDAO {

	// 등록 - 게시글에 소속된 첨부파일 등록을 위한 int(noticeNo) 리턴)
	public int adCreate(ProductVO vo) throws Exception;

	// 일반 유저 입장 - 상세보기
	public ProductVO read(int pno) throws Exception;

	// 스타트업 입장 - 상세보기
	public ProductVO readPage(int startUpId) throws Exception;

	// 수정 - 어떤게 수정된건지 확인 불가능. 전체 게시글을 싹 지우고 새로 등록시킴.
	public void adUpdate(ProductVO vo) throws Exception;

	public void adDelete(int pno) throws Exception;

	// 검색 가능한 목록
	public List<ProductVO> listSearch(SearchCriteria cri) throws Exception;

	// 검색 가능한 목록 - 페이징, 카운트
	public int listSearchCount(SearchCriteria cri) throws Exception;

	// 1. 파일 등록
	public void insertFile(ProductIMGVO fVo) throws Exception;

	// 2. 파일 삭제
	public void deleteFile(int pno) throws Exception;

	// 3. 파일 목록
	public List<ProductIMGVO> fileList(int pno) throws Exception;

	// 스타트업 관리자 페이지에서 볼때
	public List<ProductVO> adminList() throws Exception;

}