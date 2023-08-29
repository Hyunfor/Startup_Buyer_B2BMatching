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
public class ProductDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductDAOTest.class);
	
	@Inject
	private ProductDAO dao;
	
	@Test
	public void testCreate() throws Exception{
		
		ProductVO vo = new ProductVO();
		vo.setPname("새상품");
		vo.setCategory("전자기기");
		vo.setContent("상품 설명");
		vo.setStartup_Id("중견기업");
		
		logger.info("testCreate: " + vo);
		
		dao.adCreate(vo);
		
	}

}