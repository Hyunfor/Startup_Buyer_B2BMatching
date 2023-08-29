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
		vo.setPno(20); // ��ǰ ��ȣ
		vo.setCommentNo(4);
		vo.setStartup_Id("�߰߱��"); // ��ŸƮ�� ID
		vo.setBuyerId("buyer04"); // ���̾� ID
		vo.setComments("��ǰ�� ���� ��� ����");
		vo.setRegdate(new Date());

		logger.info("testCreate: " + vo);

		dao.create(vo);

	}

}