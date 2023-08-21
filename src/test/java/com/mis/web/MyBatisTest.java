package com.mis.web;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/**/root-context.xml" })
public class MyBatisTest {
	
	private static final Logger logger = LoggerFactory.getLogger(MyBatisTest.class);
	
	@Inject
	private SqlSessionFactory sqlFactory;

	@Test
	public void testFactory() throws Exception {
		
		logger.info("testFactory:" + sqlFactory);

	}
	
	@Test
	public void testSession() throws Exception {
		
		try(SqlSession session = sqlFactory.openSession()) {
			
			logger.info("testSession:" + session);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
