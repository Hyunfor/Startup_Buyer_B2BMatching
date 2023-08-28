package com.b2b.service;

import com.b2b.domain.StartUpUserVO;
import com.b2b.dto.StartUpLoginDTO;

public interface StartUpUserService {

	public StartUpUserVO login(StartUpLoginDTO dto) throws Exception;

	public void register(StartUpUserVO vo) throws Exception;

	public StartUpUserVO read(String s_id) throws Exception;

	public void modify(StartUpUserVO vo) throws Exception;

}
