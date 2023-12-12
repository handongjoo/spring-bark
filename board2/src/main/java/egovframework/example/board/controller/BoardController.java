package egovframework.example.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.board.service.BoardService;
import egovframework.example.board.vo.BoardVo;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	// --------------- jsp 페이지 렌더링 --------------- //
	
	@RequestMapping(value="/main.do")
	public String mainPage(Model model) throws Exception{
		
		List<BoardVo> list = boardService.getBoardList();
		model.addAttribute("list", list);
	
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
	
	// --------------- Board 관련 기능 --------------- //
	
	//게시글 불러오기
	
}
