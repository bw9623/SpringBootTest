package com.spring.boot.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity		// 데이터베이스 연동을 위한 모델 클래스 임을 알림
@Data
public class Board {
	@Id	// 프라이머리 키 위에 선언
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String content;
}
