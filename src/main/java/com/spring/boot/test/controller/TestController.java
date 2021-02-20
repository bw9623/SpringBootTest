package com.spring.boot.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boot.test.service.TestService;
import com.spring.boot.test.vo.TestVo;

@Controller
public class TestController {
	
	@Autowired 
	TestService testService;
	
	
	@RequestMapping(value = "/home")
	public String home() {
		
		return "redirect:index.html";
	}
	
	@ResponseBody	// view가 아닌 data를 반환해야 하는 경우 사용
	@RequestMapping(value = "/valueTest")
	public String valueTest() {
		String value = "테스트 String";
		
		return value;
	}
	
	
	// JSP
	@RequestMapping(value = "/test")
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
	
	// thymeleaf
//	@RequestMapping(value = "/thymeleafTest")
//	public String thymeleafTest(Model model) {
//		TestVo testModel = new TestVo("mean", "민병욱");
//		model.addAttribute("testModel", testModel);
//		
//		return "thymeleaf/thymeleafTest";
//	}
	
	
	@RequestMapping(value = "/dbtest")
	public ModelAndView dbtest() throws Exception{
		ModelAndView mav = new ModelAndView("test");
		
		List<TestVo> testList = testService.selectTest();
		mav.addObject("list", testList);
		
		return mav;
	}
	
	
}
