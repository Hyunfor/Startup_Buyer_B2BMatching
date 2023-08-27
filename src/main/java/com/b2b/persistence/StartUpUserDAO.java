package com.b2b.persistence;

import com.b2b.DTO.StartUpLoginDTO;
import com.b2b.domain.StartUpUserVO;

public interface StartUpUserDAO {

	public StartUpUserVO login(StartUpLoginDTO dto) throws Exception;

	public void create(StartUpUserVO vo) throws Exception;

	public StartUpUserVO read(String usid) throws Exception;

	public void update(StartUpUserVO vo) throws Exception;

}
