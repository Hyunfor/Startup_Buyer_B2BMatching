package com.b2b.persistence;

import java.util.List;

import com.b2b.domain.CommentsVO;

public interface CommentsDAO {

	public void create(CommentsVO comments);
	
	public void delete(int commentNo);
	
	public void deleteAll(int pno) throws Exception;

	// 댓글 리스트
	public List<CommentsVO> listByProduct(int pno);

}
