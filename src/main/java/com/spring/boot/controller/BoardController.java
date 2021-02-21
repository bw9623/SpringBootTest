package com.spring.boot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.boot.repository.BoardRepository;
import com.spring.boot.validator.BoardValidator;
import com.spring.boot.vo.Board;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private BoardValidator boardValidator;
	
	
	@GetMapping("/list")
	public String list(Model model, @PageableDefault(size = 15) Pageable pageable,
			  		   @RequestParam(required = false, defaultValue = "") String searchText) { 
//		Page<Board> boards = boardRepository.findAll(pageable);	// PageRequest.of(0, 20) 0 : page, 2 : size(한 페이지에 보여줄 게시글 개수)
		Page<Board> boards = boardRepository.findByTitleContainingOrContentContaining(searchText, searchText, pageable);
		// boards.getPageable();		 페이지 정보
		// boards.getTotalElements();	 전체 건수
		// boards.getTotalPages();		 총 몇개의 페이지가 있는지?
		int startPage = Math.max(1, boards.getPageable().getPageNumber() - 4);
		int endPage = Math.min(boards.getTotalPages(), boards.getPageable().getPageNumber() + 4);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("boards", boards);
		return "board/list";
	}
	
	@GetMapping("/form")
	public String form(Model model, @RequestParam(required = false) Long id) {
		if(id == null) {
			model.addAttribute("board", new Board());
		} else {
			Board board = boardRepository.findById(id).orElse(null);
			model.addAttribute("board", board);
		}
		
		
		return "board/form";
	}
	
	@PostMapping("/form")
	public String formSubmit(@Valid Board board, BindingResult bindingResult) {
		boardValidator.validate(board, bindingResult);
		if(bindingResult.hasErrors()) {
			return "board/form";
		}
		boardRepository.save(board);
		return "redirect:/board/list";
	}
}
