package com.b2b.persistence;

import com.b2b.domain.BuyerUserVO;
import com.b2b.dto.BuyerLoginDTO;

public interface BuyerUserDAO {

	public BuyerUserVO login(BuyerLoginDTO dto) throws Exception;
	
	public void create(BuyerUserVO vo) throws Exception;
	
	public BuyerUserVO read(String bId) throws Exception;
	
	public void update(BuyerUserVO vo) throws Exception;
	
}
