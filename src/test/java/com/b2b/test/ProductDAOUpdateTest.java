package com.b2b.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.b2b.domain.ProductVO;
import com.b2b.persistence.ProductDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/**/root-context.xml" })
public class ProductDAOUpdateTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductDAOUpdateTest.class);
	
	@Inject
	private ProductDAO dao;
	
	@Test
	public void testUpdate() throws Exception{
		
		ProductVO vo = new ProductVO();
		vo.setPno(1);
		vo.setPname("������ ��ǰ �̸�");
		vo.setCategory("������ ī�װ�");
		vo.setContent("������ ��ǰ ����");
		vo.setStartup_Id("��ȭ�ȱ��");
		
		logger.info("testUpdate: " + vo);
		
		dao.adUpdate(vo);
		
	}

}