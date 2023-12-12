package egovframework.example.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	// --------------- jsp 페이지 렌더링 --------------- //
	
	@RequestMapping(value="/main.do")
	public String mainPage() {
		return "main";
	}
	
	@RequestMapping(value="/boardDetail.do")
	public String boardDetailPage() {
		return "boardDetail";
	}
	
	@RequestMapping(value="/boardUpdate.do")
	public String boardUpdatePage() {
		return "boardUpdate";
	}
	
}
