package com.spring.boot.test.vo;

// 데이터를 관리하는 클래스, 데이터를 View로 넘겨줄때 사용하는 객체. 흔히 관념적으로 모델이라고 하며 DTO, VO 라는 표현을 많이 쓴다.
public class TestVo {
//	private Long mbrNo;
	private String id;
	private String name;

//	public TestVo() {
//	}

//	public TestVo(String id, String name) {
//		this.id = id;
//		this.name = name;
//	}

//	public Long getMbrNo() {
//		return mbrNo;
//	}
//
//	public void setMbrNo(Long mbrNo) {
//		this.mbrNo = mbrNo;
//	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
