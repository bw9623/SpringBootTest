package com.spring.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.vo.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{
	
	List<Board> findByTitle(String title);
	List<Board> findByTitleOrContent(String title, String Content); // And 도 가능
}
