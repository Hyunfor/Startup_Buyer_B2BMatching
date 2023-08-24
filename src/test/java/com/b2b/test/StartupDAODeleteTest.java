package com.b2b.test;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.b2b.domain.StartupVO;
import com.b2b.persistence.StartupDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/**/root-context.xml" })
public class StartupDAODeleteTest {
	
private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(StartupDAODeleteTest.class);
	
	@Inject
	private StartupDAO dao;
	
	@Test
	
	public void testDelete() throws Exception{
	
	
	
	// 1)1踰� 寃뚯떆湲� �궘�젣
			dao.delete("JHS15767");
			// 2)�쟾泥� 紐⑸줉 �솗�씤
			List<StartupVO> list = dao.list();

			for (StartupVO vo : list) {

				logger.info("testDelete: " + vo);
	
	
			
		}

}
}
