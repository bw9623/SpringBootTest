package com.spring.boot.vo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@ManyToMany(mappedBy = "roles")		// rolse : User 클래스에 있는 컬럼 이름 ---> 동일한 설정에 맞게 알아서 가져와줌
	@JsonIgnore
	private List<User> users;
}
