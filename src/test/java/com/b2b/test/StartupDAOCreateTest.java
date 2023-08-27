package com.b2b.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.b2b.domain.StartupVO;
import com.b2b.persistence.StartupDAO;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/**/root-context.xml" })

public class StartupDAOCreateTest {
	
	
private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(StartupDAOCreateTest.class);
	
	@Inject
	private StartupDAO dao;
	
	@Test
	
	public void testCreate() throws Exception{
		StartupVO vo = new StartupVO();
		
		vo.setStartupId("JHS157672345678");
		vo.setStartupName("순기업");
		vo.setEstablishedYear("2023/08/25");
		vo.setSizes("소기업");
		vo.setCategorys("도매업");
		vo.setBusiness("IT/service");
		vo.setNoOfEmployees("100명");
		vo.setCity("대구");
		vo.setItems("태블릿");
		vo.setEmail("JHS15767@GMAIL.COM");
		vo.setNames("정혜순순순");
	
		
		
		logger.info("testCreate: " + vo);
		dao.create(vo);
	
	

}
}
