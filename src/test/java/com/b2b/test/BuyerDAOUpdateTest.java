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

		vo.setBuyerId(1);
		vo.setBuyerName("�̸�");
		vo.setEmail("2023.08.23");
		vo.setCountry("����");
		vo.setCategory("����");
		vo.setBusiness("����");
		vo.setItems("������");
		vo.setOrderAmount("�ֹ���");

		logger.info("testUpdate: " + vo);
		dao.create(vo);

	}

}
