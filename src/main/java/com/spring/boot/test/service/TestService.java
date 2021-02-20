package com.spring.boot.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.test.mapper.TestMapper;
import com.spring.boot.test.vo.TestVo;

@Service
public class TestService {
	
	@Autowired
	public TestMapper mapper;
	
	public List<TestVo> selectTest(){
		return mapper.selectTest();
	}

}
