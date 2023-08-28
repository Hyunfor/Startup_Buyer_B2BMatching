package com.b2b.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.b2b.domain.StartUpUserVO;
import com.b2b.dto.StartUpLoginDTO;
import com.b2b.persistence.StartUpUserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/**/root-context.xml" })
public class StartUpUserLoginTest {

	private static final Logger Logger = LoggerFactory.getLogger(StartUpUserLoginTest.class);

	@Inject
	private StartUpUserDAO dao;

	@Test
		public void loginTest() {
			
			StartUpLoginDTO dto = new StartUpLoginDTO();
			dto.setsId("user00");
			dto.setsPw("user00");
			
			try {
				
			
			StartUpUserVO vo = dao.login(dto);
			Logger.info("loginTest(): " + vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
