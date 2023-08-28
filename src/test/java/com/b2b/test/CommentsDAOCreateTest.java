package com.b2b.test;

import java.util.Date;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.b2b.domain.CommentsVO;
import com.b2b.persistence.CommentsDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/**/root-context.xml" })
public class CommentsDAOCreateTest {

	private static final Logger logger = LoggerFactory.getLogger(CommentsDAOCreateTest.class);

	@Inject
	private CommentsDAO dao;

	@Test
	public void testCreate() throws Exception {

		CommentsVO vo = new CommentsVO();
		vo.setPno(20); // 상품 번호
		vo.setCommentNo(4);
		vo.setStartupId("중견기업"); // 스타트업 ID
		vo.setBuyerId("buyer04"); // 바이어 ID
		vo.setComments("상품에 대한 댓글 내용");
		vo.setRegdate(new Date());

		logger.info("testCreate: " + vo);

		dao.create(vo);

	}

}