package egovframework.example.auth.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egovframework.example.auth.service.AuthMapper;
import egovframework.example.auth.vo.AuthVo;

@Repository
public class AuthDaoImpl implements AuthDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public AuthVo getUserById(String userId) throws Exception {
		AuthMapper mapper = sqlSession.getMapper(AuthMapper.class);
		return mapper.getUserById(userId);
	}

	@Override
	public void createUser(AuthVo authVo) throws Exception {
		AuthMapper mapper = sqlSession.getMapper(AuthMapper.class);
		mapper.createUser(authVo);
	}

	@Override
	public String getUserByNick(String nickname) throws Exception {
		AuthMapper mapper = sqlSession.getMapper(AuthMapper.class);
		return mapper.getUserByNick(nickname);
	}

}
