package com.b2b.service;

import com.b2b.DTO.BuyerLoginDTO;
import com.b2b.domain.BuyerUserVO;

public interface BuyerUserService {

	public BuyerUserVO login(BuyerLoginDTO dto) throws Exception;

	public void register(BuyerUserVO vo) throws Exception;

	public BuyerUserVO read(String usid) throws Exception;

	public void modify(BuyerUserVO vo) throws Exception;

	public void remove(String usid) throws Exception;

}
