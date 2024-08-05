package com.simple.basic.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.simple.basic.board.board.BoardService;
import com.simple.basic.command.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	@Qualifier("b")
	BoardService boardService;

	@RequestMapping("/boardRegist")
	public String boardRegist() {
		return "board/boardRegist";
	}
	
	
	@RequestMapping("/boardList")
	public String boardList(Model model) {
		ArrayList<BoardVO> list = boardService.getPost();
		model.addAttribute("list", list);
		return "board/boardList";
	}
	
	@RequestMapping(value="/boardForm", method=RequestMethod.POST)
	public String boardForm(BoardVO vo) {
		boardService.regist(vo);
		return "board/boardResult";
	}
	
	@RequestMapping("/boardDelete")
	public String boardDelete(@RequestParam("num") int num) {
		boardService.delete(num);
		return "redirect:/board/boardList";
	}
}
