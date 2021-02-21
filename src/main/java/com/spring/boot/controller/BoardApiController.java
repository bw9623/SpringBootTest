package com.spring.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.repository.BoardRepository;
import com.spring.boot.vo.Board;

@RestController
@RequestMapping("/api")
public class BoardApiController {
	
	@Autowired
	private BoardRepository repository;
	
	@GetMapping("/board")
	public List<Board> all(@RequestParam(required = false, defaultValue = "") String title,
						   @RequestParam(required = false, defaultValue = "") String content){
		if(StringUtils.isEmpty(title) && StringUtils.isEmpty(content)) {
			return repository.findAll();
		} else {
			return repository.findByTitleOrContent(title, content);
		}
		
	}
	
	@PostMapping("/board")
	public Board newBoard(@RequestBody Board newBoard) {
		return repository.save(newBoard);
	}
	
	@GetMapping("/board/{id}")
	public Board one(@PathVariable Long id) {
		return repository.findById(id).orElse(null);
	}
	
	@PutMapping("/board/{id}")
	public Board replaceBoard(@RequestBody Board newBoard, @PathVariable Long id) {
		return repository.findById(id)
				.map(board -> {
					board.setTitle(newBoard.getTitle());
					board.setContent(newBoard.getContent());
					return repository.save(board);
				})
				.orElseGet(() -> {
					newBoard.setId(id);
					return repository.save(newBoard);
				});
	}
	
	@DeleteMapping("/board/{id}")
	public void deleteBoard(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}
