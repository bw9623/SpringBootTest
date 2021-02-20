package com.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.vo.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

//	List<Board> findAll();
}
