package com.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.repository.BoardRepository;
import com.spring.boot.repository.UserRepository;
import com.spring.boot.vo.Board;
import com.spring.boot.vo.User;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Board save(String username, Board board) {
		User user = userRepository.findByUsername(username);
		board.setUser(user);
		return boardRepository.save(board);
	}
}
