package egovframework.example.main.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import egovframework.example.main.service.MainService;
import egovframework.example.main.vo.CommentVo;
import egovframework.example.main.vo.MainVo;
import egovframework.example.main.vo.UserVo;

@Controller
public class MainController {
	
	@Autowired
	private MainService mainService;

	/*
	 * 회원가입 페이지 입니다.
	 */
	@RequestMapping(value="register.do")
	public String registerPage() {
		return "register";
	}
	
	/*
	 * 회원가입 기능
	 */
	@RequestMapping(value="registerUser.do", method = RequestMethod.POST)
	@ResponseBody
	public String registerUser(@ModelAttribute UserVo userVo) {
		UserVo user = mainService.findUserById(userVo.getAuthor());
		if (user != null) {
			return "fail";
		} else {
			mainService.registerUser(userVo);
			return "success";
		}
	}
	
	/*
	 * 로그인 페이지입니다.
	 */
	
	@RequestMapping(value="/login.do")
	public String loginPage() {
		return "login";
	}
	
	/*
	 * 로그인 기능
	 * 로그인 시 session 생성
	 */
	@RequestMapping(value="/loginAction.do", method = RequestMethod.POST)
	@ResponseBody
	public String getUserById(@ModelAttribute UserVo userVo, HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		
		UserVo user = mainService.findUserById(userVo.getAuthor());
		String userPassword = userVo.getPassword();
		
		if(user != null && user.getPassword().equals(userPassword)) {
			session.setAttribute("user", user);
			System.out.println("success");
			return "success";
		} else {
			System.out.println("fail");
			return "fail";
		}
	}
	
	/*
	 * 로그아웃 기능
	 */
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
	
	/*
	 * 메인 페이지입니다.
	 * 게시판 목록을 확인할 수 있습니다.
	 */
	@RequestMapping(value="/main.do")
	public String mainPage(MainVo mainVo, Model model, HttpSession session) {
		Object info = session.getAttribute("user");
		if (info == null) {
			return "login";
		} else {
			List<MainVo> list = mainService.selectList(mainVo);
			model.addAttribute("list", list);
			model.addAttribute("info", info);
			
			return "main";			
		}
	}

	/*
	 * 글 작성 페이지 입니다.
	 */
	@RequestMapping(value="/createBoard.do")
	public String createBoardPage(Model model, HttpSession session) {
		Object info = session.getAttribute("user");
		if (info == null) {
			return "login";
		} else {
			model.addAttribute("info", info);
			return "createBoard";
		}
	}
	
	/*
	 * 글 상세 페이지 입니다.
	 */
	@RequestMapping(value="/detailBoard.do")
	public String detailBoardPage(Model model, @RequestParam int board_id, HttpSession session) throws Exception {
		
		Object info = session.getAttribute("user");
		if (info == null) {
			return "login";
		} else {
			model.addAttribute("info", info);
			
			MainVo data = mainService.detailBoard(board_id);
			model.addAttribute("data", data);
			
			List<CommentVo> list = mainService.getComment(board_id);
			model.addAttribute("list", list);
			
			return "detailBoard";
		}
		
	}
	

	
	/*
	 * 확장자 확인
	 */
	private boolean isAllowedExtension(String fileExtension) {
	    // 허용된 확장자 목록 설정 (소문자로 비교)
	    List<String> allowedExtensions = Arrays.asList("jpeg", "jpg", "svg", "png");
	    return allowedExtensions.contains(fileExtension.toLowerCase());
	}
	
	/*
	 * 게시글 작성
	 */
	@PutMapping("/insertBoard.do")
	public String insertBoard(@ModelAttribute MainVo mainVo, @RequestParam("imageFile") MultipartFile imageFile) throws Exception {
	    // 파일 업로드 처리
		System.out.println("<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>호출");
	    if (!imageFile.isEmpty()) {
	        // 파일을 업로드할 경로 설정
	        String uploadDir = "/webapp/images"; // 예: "/uploads/"

	        // 업로드 디렉토리가 없으면 생성
	        File uploadPath = new File(uploadDir);
	        if (!uploadPath.exists()) {
	            uploadPath.mkdirs();
	        }

	        // UUID를 사용하여 랜덤 파일명 생성
	        String originalFileName = StringUtils.cleanPath(imageFile.getOriginalFilename());
	        String fileExtension = StringUtils.getFilenameExtension(originalFileName);

	        // 허용된 확장자만 업로드 허용
	        if (isAllowedExtension(fileExtension)) {
	            String uuidFileName = UUID.randomUUID().toString() + "." + fileExtension;

	            // 파일을 업로드할 경로에 저장
	            String filePath = uploadDir + File.separator + uuidFileName;
	            try (OutputStream os = new FileOutputStream(filePath)) {
	                os.write(imageFile.getBytes());
	            }

	            mainVo.setImageFile(filePath);
	        } else {
	            // 허용되지 않는 확장자일 경우 처리 (예: 에러 메시지 출력 또는 다른 로직 수행)
	            return "createBoard.do";
	        }
	    }
    mainService.insertBoard(mainVo);
    System.out.println(mainVo);
    return "redirect:main.do";
}
	/*
	 * 게시글 수정
	 */
    @RequestMapping(value="/updateBoard.do", method = RequestMethod.POST)
    @ResponseBody
    public String updateBoard(@ModelAttribute MainVo mainVo) {
		mainService.updateBoard(mainVo);
		return "success";   		
    }
	
	/*
	 * 게시글 삭제
	 */
	@RequestMapping(value="/deleteBoard.do", method = RequestMethod.POST)
	@ResponseBody
	public String deleteBoard(@RequestParam("board_id") int board_id) {
        mainService.deleteBoard(board_id);
        return "success";
	}

	
	/*
	 * 댓글 작성 
	 */
	@RequestMapping(value="/insertComment.do", method = RequestMethod.POST)
	public String insertComment(@ModelAttribute CommentVo commentVo) throws Exception {
		mainService.insertComment(commentVo);
		
		System.out.println(commentVo);
		
		return "redirect:detailBoard.do?board_id="+commentVo.getBoard_id();
	}
	
	/*
	 * 댓글 삭제
	 */
//	@RequestMapping(value="/deleteComment.do", method = RequestMethod.POST)
//	public String deleteComment(@RequestParam("comment_id") int comment_id) {
//		mainService.deleteComment(comment_id);
//		return 
//	}
}
