package egovframework.example.board.service;

import java.util.List;

import egovframework.example.board.vo.BoardVo;

public interface BoardService {

	List<BoardVo> getBoardList() throws Exception;

}
