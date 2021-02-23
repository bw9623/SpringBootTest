package com.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
	스프링 부트 장점
	- 매우 빠르게 스프링 개발에 관한 경험에 광범위한 접근 제공
	- 프로젝트 환경 구축에서 큰 영역을 차지하는 비기능적인 기능들을 기본적으로 제공(내장형 서버, 시큐리티, 측정, 상태 점검, 외부 설정)
 */


// @SpringBootApplication : @EnableAutoConfiguration, @ComponentScan, @Configuration을 하나로 묶어 놓은 거라고 볼 수 있다.
@SpringBootApplication
public class Application {

	// 스프링 가동을 위한 main 메소드
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}