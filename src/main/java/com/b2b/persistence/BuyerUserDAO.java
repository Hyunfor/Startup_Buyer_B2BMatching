package com.b2b.persistence;

import com.b2b.DTO.BuyerLoginDTO;
import com.b2b.domain.BuyerUserVO;

public interface BuyerUserDAO {

	public BuyerUserVO login(BuyerLoginDTO dto) throws Exception;
	
	public void create(BuyerUserVO vo) throws Exception;
	
	public BuyerUserVO read(String usid) throws Exception;
	
	public void update(BuyerUserVO vo) throws Exception;
	
	public void delete(String usid) throws Exception;
	
}
