package com.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signinView() throws Exception {
		return "user/signin";
	}
	
	/**
	 * 로그인 페이지 매핑
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String LoginView() {
		return "thymeleaf/user/login";
	}
}
