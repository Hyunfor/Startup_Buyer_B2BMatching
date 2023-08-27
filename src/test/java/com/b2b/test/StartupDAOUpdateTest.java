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
	
	vo.setStartupId("JHS15767345");
	vo.setStartupName("�젙湲곗뾽肉�");
	vo.setEstablishedYear("2023.08.24");
	vo.setSizes("����湲곗뾽");
	vo.setCategorys("�젣�젣議곗뾽");
	vo.setBusiness("IT/AI");
	vo.setNoOfEmployees("1000紐�");
	vo.setCity("�꽌�슱");
	vo.setItems("�끂�듃遺�");
	vo.setEmail("JHS15767@NAVER.COM");
	vo.setNames("�젙�삙�닚�닚");

	
	logger.info("testUpdate: " + vo);
	dao.create(vo);
	
	
	}
	
	
	
	
	

}
