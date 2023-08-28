package com.b2b.service;

import com.b2b.domain.BuyerUserVO;
import com.b2b.dto.BuyerLoginDTO;

public interface BuyerUserService {

	public BuyerUserVO login(BuyerLoginDTO dto) throws Exception;

	public void register(BuyerUserVO vo) throws Exception;

	public BuyerUserVO read(String b_id) throws Exception;

	public void modify(BuyerUserVO vo) throws Exception;

}
