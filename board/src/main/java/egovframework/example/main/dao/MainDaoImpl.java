package egovframework.example.main.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egovframework.example.main.service.MainMapper;
import egovframework.example.main.vo.CommentVo;
import egovframework.example.main.vo.MainVo;
import egovframework.example.main.vo.UserVo;

@Repository
public class MainDaoImpl implements MainDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<MainVo> selectList(MainVo mainVo) {
		MainMapper mapper = sqlSession.getMapper(MainMapper.class);
		return mapper.selectList(mainVo);
	}

	@Override
	public void insertBoard(MainVo mainVo) throws Exception {
		MainMapper mapper = sqlSession.getMapper(MainMapper.class);
        mapper.insertBoard(mainVo);
	}
	
	@Override
	public MainVo detailBoard(int board_id) throws Exception {
		MainMapper mapper = sqlSession.getMapper(MainMapper.class);
        return mapper.detailBoard(board_id);
	}

	@Override
	public List<CommentVo> getComment(int board_id) throws Exception {
		MainMapper mapper = sqlSession.getMapper(MainMapper.class);
		return mapper.getComment(board_id);
	}

	@Override
	public void insertComment(CommentVo commentVo) {
		MainMapper mapper = sqlSession.getMapper(MainMapper.class);
		mapper.insertComment(commentVo);
		
	}

	@Override
	public UserVo findUserById(String author) {
		MainMapper mapper = sqlSession.getMapper(MainMapper.class);
		return mapper.findUserById(author);
		
	}

	@Override
	public void updateBoard(MainVo mainVo) {
		MainMapper mapper = sqlSession.getMapper(MainMapper.class);
		mapper.updateBoard(mainVo);
		
	}

	@Override
	public void deleteBoard(int board_id) {
		MainMapper mapper = sqlSession.getMapper(MainMapper.class);
		mapper.deleteBoard(board_id);
	}

	@Override
	public void registerUser(UserVo userVo) {
		MainMapper mapper = sqlSession.getMapper(MainMapper.class);
		mapper.registerUser(userVo);
	}
}
