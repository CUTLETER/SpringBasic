package com.simple.basic.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.basic.command.MemberVO;

@Controller
@RequestMapping("/response") // 요청 경로 1
public class ResponseController {

	@RequestMapping("/res_ex01") // 요청 경로 2
	public String ex01() {
		return "response/res_ex01"; // 나가는 경로
	}
	
	
	// 값을 전달하는 방법 Model (requesst.setattribute랑 같음, 가장 많이 쓰임) , ModelAndView, ModelAttribute 등
	
	
	
	// model 전달자
//	@RequestMapping("/res_ex02") 
//	public String ex02(ModelMap model) {
//		model.addAttribute("data", "홍길동"); // 키, 값 //  = request.setAttribute(키, 값)
//		model.addAttribute("now", new Date());
//		
//		return "response/res_ex02";
//	}

	
	// modelAndView 전달자
	@RequestMapping("/res_ex02")
	public ModelAndView ex02() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", "이순신"); // 여기에 데이터를 담음
		mv.addObject("now", new Date());
		mv.setViewName("response/res_ex02"); // 화면에 대한 경로

		return mv;
	}
	
	
	// modelAttribute = request + model 합성어
	// 값을 받을 수도 있고 다음 화면에 전달할 수도 있음
	@RequestMapping("/res_ex03")
	public String ex03(@ModelAttribute("info") String info) {
		System.out.println(info); // info 라는 이름으로 데이터를 넘겨줌 -> res_ex03 에서 그대로 받을 수 있음
		return "response/res_ex03";
	}
	
	@RequestMapping("/res_ex04")
	public String ex04(@ModelAttribute("info") MemberVO vo) { // vo로 맵핑하고 info로 값을 넘김
		System.out.println(vo.toString());
		return "response/res_ex04";
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	
	// 리다이렉트?
	// 스프링은 기본 이동방식이 'forward'
	// '리다이렉트는 다시 컨트롤러에 태울 용도로 쓰임'
	
	@RequestMapping("/login")
	public String loginView() {
		
		System.out.println("리다이렉트 타고 나감");
		return "response/login";
	}
	
	@RequestMapping(value="/loginForm", method=RequestMethod.POST)
	public String loginForm(MemberVO vo,
							RedirectAttributes ra) {
		// id랑 pw가 동일하면 로그인 성공
		String id = vo.getId();
		String pw = vo.getPw();
		if (id.equals(pw)) {
			// 어떤 데이터를 보낼 필요 없을 떈 redirect (새로운 경로로 이동)
			return "response/login_ok";
		} else { 
			// 다시 컨트롤러 타서 /login 경로 타고 로그인 페이지로 넘어감
			// 리다이렉트를 보낼 때 딱 한 번! 데이터로 넘기는 방식을 제공해줌
			ra.addFlashAttribute("msg", "일치하지 않다");
			
			// redirect 쓰는 방법 :
			return "redirect:/response/login"; // 기본 forward 방식 아니고 redirect 방식으로
			
		}
	}
}
