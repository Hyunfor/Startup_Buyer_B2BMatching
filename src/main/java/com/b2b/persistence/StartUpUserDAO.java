package com.b2b.persistence;

import com.b2b.domain.StartUpUserVO;
import com.b2b.dto.StartUpLoginDTO;

public interface StartUpUserDAO {

	public StartUpUserVO login(StartUpLoginDTO dto) throws Exception;

	public void create(StartUpUserVO vo) throws Exception;

	public StartUpUserVO read(String sId) throws Exception;

	public void update(StartUpUserVO vo) throws Exception;

}
