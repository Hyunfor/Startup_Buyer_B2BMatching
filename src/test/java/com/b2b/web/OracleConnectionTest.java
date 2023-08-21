package com.b2b.web;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OracleConnectionTest {

	// JUnit 테스트. ppt 및 포트폴리오 작성 시 JUint 테스트도 가능하단걸 필수로 적기!
	
	// 오라클 접속정보 설정
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@:localhost:1521:XE";
	private static final String USER ="b2b2023";
	private static final String PW = "1234";
	
	private static final Logger logger = LoggerFactory.getLogger(OracleConnectionTest.class);
	
	@Test
	public void testConnection() throws Exception {
		
		// 1) JDBC 드라이버 로드
		Class.forName(DRIVER);
		
		// 2) 오라클 데이터베이스 접속
		try(Connection conn = DriverManager.getConnection(URL, USER, PW)) {
			
			logger.info("JUNIT:" + conn);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
