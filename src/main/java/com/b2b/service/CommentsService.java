package com.b2b.service;

import java.util.List;

import com.b2b.domain.CommentsVO;

public interface CommentsService {
	
	public void create(CommentsVO comments);

	public void delete(int commentNo);
	
	public void deleteAll(int pno) throws Exception;

	// ´ñ±Û ¸®½ºÆ®
	public List<CommentsVO> listByProduct(int pno);

}
