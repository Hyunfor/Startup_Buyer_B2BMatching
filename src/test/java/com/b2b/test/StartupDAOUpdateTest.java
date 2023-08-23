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

public class StartupDAOUpdateTest {
	
	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(StartupDAOUpdateTest.class);
	
	@Inject
	private StartupDAO dao;
	
	
	@Test
	public void testUpdate() throws Exception{
		
	StartupVO vo = new StartupVO();
	
	vo.setStartup_id("JHS15767345");
	vo.setStartupName("정기업뿡");
	vo.setEstablished_Year("2023.08.24");
	vo.setSizes("대대기업");
	vo.setCategorys("제제조업");
	vo.setBusiness("IT/AI");
	vo.setNo_Of_Employess("1000명");
	vo.setCity("서울");
	vo.setItems("노트북");
	vo.setEmail("JHS15767@NAVER.COM");
	vo.setNames("정혜순순");

	
	logger.info("testUpdate: " + vo);
	dao.create(vo);
	
	
	}
	
	
	
	
	

}
