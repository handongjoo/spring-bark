package egovframework.example.board.service;

import java.util.List;

import egovframework.example.board.vo.BoardVo;

public interface BoardMapper {

	List<BoardVo> getBoardList() throws Exception;

	void createBoard(BoardVo boardVo) throws Exception;

	void updateBoard(BoardVo boardVo) throws Exception;

	void deleteBoard(int boardId) throws Exception;

	BoardVo getBoardDetail(int boardId) throws Exception;

}
