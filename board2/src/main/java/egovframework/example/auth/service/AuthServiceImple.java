package egovframework.example.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.auth.dao.AuthDao;
import egovframework.example.auth.vo.AuthVo;

@Service
public class AuthServiceImple implements AuthService {
	
	@Autowired
	private AuthDao authDao;

	@Override
	public AuthVo getUserById(String userId) throws Exception {
		return authDao.getUserById(userId);
	}

	@Override
	public void createUser(AuthVo authVo) throws Exception {
		authDao.createUser(authVo);
		
	}

	@Override
	public String getUserByNick(String nickname) throws Exception {
		return authDao.getUserByNick(nickname);
	}

}
