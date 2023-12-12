package egovframework.example.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import egovframework.example.auth.service.AuthService;
import egovframework.example.auth.vo.AuthVo;

@Controller
public class AuthController {

	@Autowired
	private AuthService authService;
	
	// --------------- jsp 페이지 렌더링 --------------- //
	
	@RequestMapping(value="/signIn.do")
	public String signInPage() {
		return "signIn";
	}
	
	@RequestMapping(value="/signUp.do")
	public String signUpPage() {
		return "signUp";
	}
	
	// --------------- Auth 관련 기능 --------------- //
	
	// 회원가입
	@RequestMapping(value="/createUser", method = RequestMethod.POST)
	public String createUser(AuthVo authVo) throws Exception {
		AuthVo user = authService.getUserById(authVo.getUserId());
		
		if(user != null) {
			return "fail";
		}
		authService.createUser(authVo);
		return "success";
	}
	
	// 로그인
	@RequestMapping(value="/loginUser", method = RequestMethod.POST)
	public String loginUser(AuthVo authVo) throws Exception {
		AuthVo user = authService.getUserById(authVo.getUserId());
		
		if(user == null || !authVo.getPassword().equals(user.getPassword())) {
			return "fail";
		}
		return "success";
	}
	
}
