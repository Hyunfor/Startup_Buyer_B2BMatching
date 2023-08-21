package com.mis.persistence;

import com.mis.domain.UserVO;
import com.mis.dto.LoginDTO;

public interface UserDAO {

	public UserVO login(LoginDTO dto) throws Exception;
	
	public void create(UserVO vo) throws Exception;
	
	public UserVO read(String usid) throws Exception;
	
	public void update(UserVO vo) throws Exception;
	
	public void delete(String usid) throws Exception;
	
}
