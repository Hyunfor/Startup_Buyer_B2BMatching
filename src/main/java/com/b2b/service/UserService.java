package com.mis.service;

import com.mis.domain.UserVO;
import com.mis.dto.LoginDTO;

public interface UserService {

	public UserVO login(LoginDTO dto) throws Exception;

	public void register(UserVO vo) throws Exception;

	public UserVO read(String usid) throws Exception;

	public void modify(UserVO vo) throws Exception;

	public void remove(String usid) throws Exception;

}
