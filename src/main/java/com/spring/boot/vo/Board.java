package com.spring.boot.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity		// 데이터베이스 연동을 위한 모델 클래스 임을 알림
@Data
public class Board {
	@Id	// 프라이머리 키 위에 선언
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=2, max=30, message = "제목은 2자 이상 30자 이하입니다.")
	private String title;
	private String content;
}
