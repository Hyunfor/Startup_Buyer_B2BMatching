package com.b2b.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.b2b.domain.BuyerVO;
import com.b2b.persistence.BuyerDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/**/root-context.xml" })

public class BuyerDAOUpdateTest {

	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(BuyerDAOUpdateTest.class);

	@Inject
	private BuyerDAO dao;

	@Test
	public void testUpdate() throws Exception {

		BuyerVO vo = new BuyerVO();

		vo.setBuyerId(12);
		vo.setBuyerName("user2");
		vo.setEmail("2023.08.02");
		vo.setCountry("지구1");
		vo.setCategory("수출 유통 전문");
		vo.setBusiness("유통");
		vo.setItems("전자기기");
		vo.setOrderAmount("1000");

		logger.info("testUpdate: " + vo);
		dao.update(vo);

	}

}
