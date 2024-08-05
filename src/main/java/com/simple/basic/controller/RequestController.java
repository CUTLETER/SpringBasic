package com.simple.basic.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.basic.command.MemberVO;

@Controller
@RequestMapping("/request") // 컨트롤러 모든 요청 경로 앞에 /request를 붙이겠다는 뜻
public class RequestController {
	
	
	// 값을 받는 방법 VO >>>> RequestParam (단일 값) >>>>>> 기타 등등 순으로 많이 쓰임
	

//	void형은 들어온 요청 경로가 화면으로 나가는 경로와 같음
//	@RequestMapping("/req_ex01")
//	public void ex01() {
//		
//	}	
	
	@RequestMapping("/req_ex01")
	public String ex01() {
		return "request/req_ex01"; // 리턴에 실리는 경로
	}
	
//	@RequestMapping(value="/basic", method=RequestMethod.GET) // get만 허용됨
//	@RequestMapping(value="/basic", method=RequestMethod.POST) // post만 허용됨
//	@RequestMapping("/basic") // get, post 둘 다 허용됨
	@RequestMapping({"/basic", "/basic2"}) // 요청 경로가 같다면 한꺼번에 묶을 수도 있음
	public String basic() {
		
		System.out.println("basic 요청 실행됨");
		return null;
	}
	
//	@GetMapping("/basic3") // 리퀘스트 맵핑 + get만 허용됨
	@PostMapping("/basic3") // 리퀘스트 맵핑 + post만 허용됨
	public String basic3() {
		System.out.println("basic3 요청 실행됨");
		return null;
	}
	
	
	//////////////////////////////////////////////////////////////////////////
	
	
	// Ex02 화면 요청
	@RequestMapping("/req_ex02")
	public String ex02() {
		return "request/req_ex02";
	}
	
//	@RequestMapping(value="/param", method=RequestMethod.POST)
//	public String param(HttpServletRequest request) { // request 객체를 쓸 수 있어짐
//		
//		System.out.println(request.getParameter("id"));
//		System.out.println(request.getParameter("pw"));
//		System.out.println(request.getParameterValues("inter"));
//		
//		return "request/req_ex02_ok";
//	}

	
	// @RequestParam 방식 - '반드시' 값을 화면에서 넘겨야 함
	// required = false 속성을 주면 값이 없더라도 일단 통과시킴
	// defaultValue는 값이 없을때 기본값을 지정할 수 있음
//	@RequestMapping(value="/param", method=RequestMethod.POST)
//	public String param(@RequestParam("id") String x,  // input 태그의 name 값이 들어감, 그 값을 변수 x에 맵핑시킴
//						@RequestParam("pw") String y,  // pw 값을 변수 y에 맵핑시킴
//						@RequestParam(value="inter", required=false, defaultValue = "") ArrayList<String> list) {
//			
//		System.out.println(x);
//		System.out.println(y);
//		System.out.println(list.toString());
//		return "request/req_ex02_ok";
//	}
	
	
	@RequestMapping(value="/param", method=RequestMethod.POST)
	public String param(MemberVO vo) {
			System.out.println(vo.toString());
		return "request/req_ex02_ok";
	}
	
	
	
	
}
