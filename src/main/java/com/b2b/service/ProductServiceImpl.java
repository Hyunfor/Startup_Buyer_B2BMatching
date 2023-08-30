package com.b2b.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.b2b.domain.ProductIMGVO;
import com.b2b.domain.ProductVO;
import com.b2b.domain.SearchCriteria;
import com.b2b.persistence.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {

	@Inject
	private ProductDAO dao;

	@Override
	public void register(ProductVO vo) throws Exception {
		// 1.TextArea 줄바꿈 처리 - 유저에게 받을때 HTML로 변환해서 DB에 잠시 담았다가 꺼낼때 다시 변환
		String content = vo.getContent().replace("\\r\\n", "<br>");
		vo.setContent(content);

		// 2. 상품 기본 내용 저장(첨부파일 제외) - > PK인 pno 받아오기
		int pno = dao.adCreate(vo);

		// 3.첨부파일 등록
		// 3-1) 첨부파일 존재 유무 확인
		if (vo.getFiles() != null) {

			// 3-2) 다중 첨부파일 저장
			for (int i = 0; i < vo.getFiles().length; i++) {
				ProductIMGVO fVo = new ProductIMGVO();
				fVo.setPno(pno);
				fVo.setImgName(vo.getFiles()[i]);

				dao.insertFile(fVo);
			}
		}
	}

	@Override
	public ProductVO read(int pno) throws Exception {
		return dao.read(pno);
	}
	
	@Override
	public ProductVO readPage(int startUpId) throws Exception {
		return dao.readPage(startUpId);
	}

	@Override
	public void modify(ProductVO vo) throws Exception {
		// 1.TextArea 줄바꿈 처리 - 유저에게 받을때 HTML로 변환해서 DB에 잠시 담았다가 꺼낼때 다시 변환
		String content = vo.getContent().replace("\\r\\n", "<br>");
		vo.setContent(content);

		// 2. 상품 기본 내용 수정(첨부파일 제외)
		dao.adUpdate(vo);

		// 3. 기존의 첨부파일을 전부 삭제
		dao.deleteFile(vo.getPno());

		// 4.첨부파일 등록
		// 4-1) 첨부파일 존재 유무 확인
		if (vo.getFiles() != null) {

			// 4-2) 다중 첨부파일 저장
			for (int i = 0; i < vo.getFiles().length; i++) {
				ProductIMGVO fVo = new ProductIMGVO();
				fVo.setPno(vo.getPno());
				fVo.setImgName(vo.getFiles()[i]);

				dao.insertFile(fVo);
			}
		}
	}

	@Override
	public void remove(int pno) throws Exception {
		// 1.첨부파일 삭제
		dao.deleteFile(pno);

		// 2. 상품 삭제
		dao.adDelete(pno);
	}

	@Override
	public List<ProductVO> listSearch(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}

	@Override
	public List<ProductIMGVO> fileList(int pno) throws Exception {
		return dao.fileList(pno);
	}

}