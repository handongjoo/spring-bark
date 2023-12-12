package egovframework.example.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import egovframework.example.board.service.BoardService;
import egovframework.example.board.vo.BoardVo;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	// --------------- jsp 페이지 렌더링 --------------- //
	
	// 메인 페이지 + 게시글 목록
	@RequestMapping(value="/main.do")
	public String mainPage(Model model) throws Exception{
		
		List<BoardVo> list = boardService.getBoardList();
		model.addAttribute("list", list);
	
		return "main";
	}
	
	// 게시글 상세 페이지
	@RequestMapping(value="/boardDetail.do")
	public String boardDetailPage(Model model, int boardId) throws Exception {
		
		BoardVo boardVo = boardService.getBoardDetail(boardId);
		model.addAttribute(boardVo);
		
		return "boardDetail";
	}
	
	// 게시글 수정 페이지
	@RequestMapping(value="/boardUpdate.do")
	public String boardUpdatePage() {
		
		return "boardUpdate";
	}
	
	// --------------- Board 관련 기능 --------------- //
	
	// 게시글 작성
	@RequestMapping(value="/createBoard.do", method = RequestMethod.POST)
	public void createBoard(BoardVo boardVo) throws Exception {
		boardService.createBoard(boardVo);
	}
	
	// 게시글 수정
	@RequestMapping(value="/updateBoard.do", method = RequestMethod.POST)
	public void updateBoard(BoardVo boardVo) throws Exception {
		boardService.updateBoard(boardVo);
	}
	
	// 게시글 삭제
	@RequestMapping(value="/deleteBoard.do", method = RequestMethod.POST)
	public void deleteBoard(int boardId) throws Exception {
		boardService.deleteBoard(boardId);
	}
	
}
