package egovframework.example.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.board.dao.BoardDao;
import egovframework.example.board.vo.BoardVo;

@Service
public class BoardServiceImple implements BoardService {
	
	@Autowired
	private BoardDao boardDao;

	@Override
	public List<BoardVo> getBoardList() throws Exception {
		return boardDao.getBoardList();
	}

	@Override
	public void createBoard(BoardVo boardVo) throws Exception {
		boardDao.createBoard(boardVo);
		
	}

	@Override
	public void updateBoard(BoardVo boardVo) throws Exception {
		boardDao.updateBoard(boardVo);
		
	}

	@Override
	public void deleteBoard(int boardId) throws Exception {
		boardDao.deleteBoard(boardId);
		
	}

	@Override
	public BoardVo getBoardDetail(int boardId) throws Exception {
		return boardDao.getBoardDetail(boardId);
	}

}
