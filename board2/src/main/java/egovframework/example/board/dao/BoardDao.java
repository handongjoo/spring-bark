package egovframework.example.board.dao;

import java.util.List;

import egovframework.example.board.vo.BoardVo;

public interface BoardDao {

	List<BoardVo> getBoardList() throws Exception;

	void createBoard(BoardVo boardVo) throws Exception;

	void updateBoard(BoardVo boardVo) throws Exception;

	void deleteBoard(int boardId) throws Exception;

	BoardVo getBoardDetail(int boardId) throws Exception;

}
