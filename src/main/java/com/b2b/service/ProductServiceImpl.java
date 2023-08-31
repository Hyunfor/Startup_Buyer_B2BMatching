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
		// 1.TextArea �ٹٲ� ó�� - �������� ������ HTML�� ��ȯ�ؼ� DB�� ��� ��Ҵٰ� ������ �ٽ� ��ȯ
		String content = vo.getContent().replace("\\r\\n", "<br>");
		vo.setContent(content);

		// 2. ��ǰ �⺻ ���� ����(÷������ ����) - > PK�� pno �޾ƿ���
		int pno = dao.adCreate(vo);

		// 3.÷������ ���
		// 3-1) ÷������ ���� ���� Ȯ��
		if (vo.getFiles() != null) {

			// 3-2) ���� ÷������ ����
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
		// 1.TextArea �ٹٲ� ó�� - �������� ������ HTML�� ��ȯ�ؼ� DB�� ��� ��Ҵٰ� ������ �ٽ� ��ȯ
		String content = vo.getContent().replace("\\r\\n", "<br>");
		vo.setContent(content);

		// 2. ��ǰ �⺻ ���� ����(÷������ ����)
		dao.adUpdate(vo);

		// 3. ������ ÷�������� ���� ����
		dao.deleteFile(vo.getPno());

		// 4.÷������ ���
		// 4-1) ÷������ ���� ���� Ȯ��
		if (vo.getFiles() != null) {

			// 4-2) ���� ÷������ ����
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
		// 1.÷������ ����
		dao.deleteFile(pno);

		// 2. ��ǰ ����
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