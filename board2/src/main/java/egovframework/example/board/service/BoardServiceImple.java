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

}
