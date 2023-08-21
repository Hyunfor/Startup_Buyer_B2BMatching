package com.b2b.service;

import com.b2b.DTO.LoginDTO;
import com.b2b.domain.UserVO;


public interface UserService {

	public UserVO login(LoginDTO dto) throws Exception;

	public void register(UserVO vo) throws Exception;

	public UserVO read(String usid) throws Exception;

	public void modify(UserVO vo) throws Exception;

	public void remove(String usid) throws Exception;

}
