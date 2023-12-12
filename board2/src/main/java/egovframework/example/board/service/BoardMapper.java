package egovframework.example.board.service;

import java.util.List;

import egovframework.example.board.vo.BoardVo;

public interface BoardMapper {

	List<BoardVo> getBoardList() throws Exception;

}
