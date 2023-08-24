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
		
		vo.setStartup_id("JHS157672");
		vo.setStartupName("정기업");
		vo.setEstablished_Year("2023.08.23");
		vo.setSizes("대기업");
		vo.setCategorys("제조업");
		vo.setBusiness("IT/통신업");
		vo.setNo_Of_Employees("10000명");
		vo.setCity("대전");
		vo.setItems("핸드폰");
		vo.setEmail("JHS15767@GMAIL.COM");
		vo.setNames("정혜순");
	
		
		
		logger.info("testCreate: " + vo);
		dao.create(vo);
	
	

}
}
