package egovframework.example.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egovframework.example.board.service.BoardMapper;
import egovframework.example.board.vo.BoardVo;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<BoardVo> getBoardList() throws Exception {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.getBoardList();
	}

}
