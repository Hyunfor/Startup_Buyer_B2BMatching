package com.b2b.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.b2b.domain.CommentsVO;

@Repository
public class CommentsDAOImpl implements CommentsDAO {
	
	@Inject
	private SqlSession session;

	private static final String namespace = "com.b2b.mapper.CommentsMapper";

	@Override
	public void create(CommentsVO comments) {
		session.insert(namespace + ".create", comments);
	}

	@Override
	public void delete(int commentNo) {
		session.delete(namespace + ".delete", commentNo);
		
	}
	
	@Override
	public void deleteAll(int pno) throws Exception {
		session.delete(namespace + ".deleteAll", pno);

	}

	@Override
	public List<CommentsVO> listByProduct(int pno) {
		 return session.selectList(namespace + ".listByProduct", pno);
	}

}
