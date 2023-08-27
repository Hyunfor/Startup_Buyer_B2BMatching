package com.b2b.service;

import com.b2b.DTO.StartUpLoginDTO;
import com.b2b.domain.StartUpUserVO;

public interface StartUpUserService {

	public StartUpUserVO login(StartUpLoginDTO dto) throws Exception;

	public void register(StartUpUserVO vo) throws Exception;

	public StartUpUserVO read(String usid) throws Exception;

	public void modify(StartUpUserVO vo) throws Exception;

}
