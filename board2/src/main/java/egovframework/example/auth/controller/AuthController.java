package egovframework.example.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.auth.service.AuthService;

@Controller
public class AuthController {

	@Autowired
	private AuthService AuthService;
	
	@RequestMapping(value="/signIn.do")
	public String signInPage() {
		return "signIn";
	}
	
	@RequestMapping(value="/signUp.do")
	public String signUpPage() {
		return "signUp";
	}
}
