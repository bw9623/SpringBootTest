package com.spring.boot.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	@RequestMapping(value = "/home")
	public String home() {
		return "index.html";
	}
	
	@ResponseBody	// view가 아닌 data를 반환해야 하는 경우 사용
	@RequestMapping(value = "/valueTest")
	public String valueTest() {
		String value = "테스트 String";
		return value;
	}
	
	@RequestMapping("/test")
	public ModelAndView test() throws Exception {
		ModelAndView mav = new ModelAndView("test");
		mav.addObject("name", "민병욱");
		
		List<String> testList = new ArrayList<String>();
		testList.add("a");
		testList.add("b");
		testList.add("c");
		
		mav.addObject("list", testList);
		return mav;
	}
}
