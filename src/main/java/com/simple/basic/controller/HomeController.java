package com.simple.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller /*컴포넌트 스캔이 읽어서 bean(객체)로 생성함*/
public class HomeController {

	// 핸들러 어댑터와 연결
	@RequestMapping("/home")
	public String home() {
		return "home"; // WEF-INF/views/home.jsp
	}
}
