package egovframework.example.auth.dao;

import egovframework.example.auth.vo.AuthVo;

public interface AuthDao {

	AuthVo getUserById(String userId) throws Exception;

	void createUser(AuthVo authVo) throws Exception;

	String getUserByNick(String nickname) throws Exception;

}
