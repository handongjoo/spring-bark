package egovframework.example.auth.service;

import egovframework.example.auth.vo.AuthVo;

public interface AuthService {

	AuthVo getUserById(String userId) throws Exception;

	void createUser(AuthVo authVo) throws Exception;

	String getUserByNick(String nickname) throws Exception;

}
