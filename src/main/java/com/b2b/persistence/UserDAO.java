package com.b2b.persistence;

import com.b2b.domain.UserVO;
import com.b2b.dto.LoginDTO;

public interface UserDAO {

	public UserVO login(LoginDTO dto) throws Exception;
	
	public void create(UserVO vo) throws Exception;
	
	public UserVO read(String usid) throws Exception;
	
	public void update(UserVO vo) throws Exception;
	
	public void delete(String usid) throws Exception;
	
}
