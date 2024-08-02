package com.simple.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.basic.command.MemberVO;
import com.simple.basic.command.QuizVO;

@Controller
@RequestMapping("/quiz")
public class QuizController {
	
	
	@RequestMapping("/quiz01")
	public String joinView() {
		return "quiz/quiz01";
	}

	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinForm(@ModelAttribute("user") QuizVO vo) { // 또는 (QuizVO vo, Model model) 적고 {model.setAttribute("vo", vo)} 이렇게 담아도 됨
		String id = vo.getId();
		String pw = vo.getPw();
		String name = vo.getName();
		String email = vo.getEmail();
		return "quiz/quiz01_ok";
	}
	
	//////////////////////////////////////////////////
	
	
	@RequestMapping("/quiz02")
	public String quiz() {
		return "quiz/quiz02";
	}
	
	@RequestMapping("/result")
	public String result() {
		return "quiz/quiz02_result";
	}
	
	@RequestMapping(value="/birthForm", method=RequestMethod.POST)
	public String birthForm(@RequestParam("year") String year,
							@RequestParam("month") String month,
							 @RequestParam("day") String day,
							 @RequestParam("msg") String msg,
							 RedirectAttributes ra) {
		String birthday = year+ "" + month + "" + day + msg;
		ra.addFlashAttribute("birthday",birthday);
		return "redirect:/quiz/quiz02_result";
	}

	
}
