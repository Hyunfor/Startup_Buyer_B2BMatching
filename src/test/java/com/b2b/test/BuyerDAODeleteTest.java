package com.b2b.test;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.b2b.domain.BuyerVO;
import com.b2b.persistence.BuyerDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/**/root-context.xml" })
public class BuyerDAODeleteTest {

	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(BuyerDAODeleteTest.class);

	@Inject
	private BuyerDAO dao;

	@Test

	public void testDelete() throws Exception {

		dao.delete(1);
		List<BuyerVO> list = dao.list();

		for (BuyerVO vo : list) {

			logger.info("testDelete: " + vo);

		}

	}
}
