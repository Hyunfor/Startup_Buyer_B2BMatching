package com.b2b.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.b2b.domain.ProductIMGVO;
import com.b2b.domain.ProductVO;
import com.b2b.domain.SearchCriteria;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Inject
	private SqlSession session;

	private static final String namespace = "com.b2b.mapper.ProductMapper";

	@Override
	public int adCreate(ProductVO vo) throws Exception {
		// vo에 담아서 getPno 리턴
		session.insert(namespace + ".adCreate", vo);
		return vo.getPno();
	}

	@Override
	public ProductVO read(int pno) throws Exception {
		return session.selectOne(namespace + ".read", pno);
	}
	
	@Override
	public ProductVO readPage(int startUpId) throws Exception {
		return session.selectOne(namespace + ".readPage", startUpId);
	}

	@Override
	public void adUpdate(ProductVO vo) throws Exception {
		session.update(namespace + ".adUpdate", vo);
	}

	@Override
	public void adDelete(int pno) throws Exception {
		session.delete(namespace + ".adDelete", pno);
	}

	@Override
	public List<ProductVO> listSearch(SearchCriteria cri) throws Exception {
		return session.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".listSearchCount", cri);
	}

	@Override
	public void insertFile(ProductIMGVO fVo) throws Exception {
		session.insert(namespace + ".insertFile", fVo);
	}

	@Override
	public void deleteFile(int pno) throws Exception {
		session.delete(namespace + ".deleteFile", pno);
	}

	@Override
	public List<ProductIMGVO> fileList(int pno) throws Exception {
		return session.selectList(namespace + ".fileList", pno);
	}

	// 스타트업 관리자 페이지에서 보는 리스트
	@Override
	public List<ProductVO> adminList() throws Exception {
		return session.selectList(namespace + ".adminList");
	}

}