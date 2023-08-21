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
		vo.setPname("수정된 상품 이름");
		vo.setCategory("수정된 카테고리");
		vo.setContent("수정된 상품 설명");
		vo.setstartup_id("변화된기업");
		
		logger.info("testUpdate: " + vo);
		
		dao.update(vo);
		
	}

}