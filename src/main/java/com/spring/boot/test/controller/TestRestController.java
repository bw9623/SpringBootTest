package com.spring.boot.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// @RestController를 사용하면 @ResponseBody를 추가 할 필요가 없고, @ResponseBody 어노테이션은 기본적으로 활성화되어 있다.
@RestController
public class TestRestController {
	
	@RequestMapping(value="/testValue", method = RequestMethod.GET)
	public String getTestValue() {
		String TestValue = "레스트컨트롤러 테스트";
		return TestValue;
	}
}
