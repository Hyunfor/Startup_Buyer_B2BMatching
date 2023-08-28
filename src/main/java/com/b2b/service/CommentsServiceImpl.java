package com.b2b.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.b2b.domain.CommentsVO;
import com.b2b.persistence.CommentsDAO;

@Service
public class CommentsServiceImpl implements CommentsService {

	@Inject
    private CommentsDAO dao;

	@Override
	public void create(CommentsVO comments) {
		dao.create(comments);
	}

	@Override
	public void delete(int commentNo) {
		 dao.delete(commentNo);
	}
	
	@Override
	public void deleteAll(int pno) throws Exception {
		dao.deleteAll(pno);
		
	}

	@Override
	public List<CommentsVO> listByProduct(int pno) {
		 return dao.listByProduct(pno);
	}

    
}
