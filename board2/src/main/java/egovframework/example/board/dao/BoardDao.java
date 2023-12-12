package egovframework.example.board.dao;

import java.util.List;

import egovframework.example.board.vo.BoardVo;

public interface BoardDao {

	List<BoardVo> getBoardList() throws Exception;

}
