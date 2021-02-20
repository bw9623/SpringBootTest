package com.spring.boot.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.spring.boot.test.vo.TestVo;

@Repository
@Mapper
public interface TestMapper { 			//mapper.xml의 mapper tag 안에 선언한 namespace 에 정확하게 일치하는 위치에 같은 이름으로 생성해야 한다.
	List<TestVo> selectTest();		//그리고 select tag 안에 선언한 id 값과 각 method 이름을 같게 생성해야 한다.
}
