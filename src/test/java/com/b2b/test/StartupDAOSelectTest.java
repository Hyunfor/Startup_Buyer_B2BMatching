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



public class StartupDAOSelectTest {
	
	
private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(StartupDAOSelectTest.class);
	
	@Inject
	private StartupDAO dao;
	
	
	
	@Test
	public void testList() throws Exception{
		
		List<StartupVO> list = dao.list();
		
		 for(StartupVO vo : list) {
			 
			 logger.info("testListAll: " + vo);
			 
		 }
		
	
	
	}
	
	@Test
	public void testRead() throws Exception{
		
		logger.info("testRead: " + dao.read("JHS15767"));
			 
		 }
	
	
	
	
	

}
