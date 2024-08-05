package com.simple.basic.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.basic.command.ScoreVO;
import com.simple.basic.service.score.ScoreService;
import com.simple.basic.service.score.ScoreServiceImpl;

@Controller
@RequestMapping("/service")
public class ScoreController {

	//	첫번째 방법 - 100번 요청 들어오면 100개 만들어야 하는 단점
	//	ScoreService service = new ScoreServiceImpl();
	
	// 두번째 방법 - servlet-context.xml 가서 서비스 영역(scoreserviceimpl)을 bean으로 등록
	// 세 번째 방법 -서비스 영역(scoreserviceimpl)에 @Service("x") 이런 식으로 뚜껑 씌워주기

	
	@Autowired
	@Qualifier("x") // scoreserviceimpl의 뚜껑인 @Service("x")와 동일한 이름으로! 서비스 객체가 여럿일 때 이름으로 찾는 방식!
	ScoreService scoreService;

	// 목록
	@RequestMapping("/scoreList")
	public String scoreList(Model model) {
		// select해서 model에 담아서 화면으로 실어 보내기
		ArrayList<ScoreVO> list = scoreService.getScore();
		model.addAttribute("list", list);
		return "service/scoreList";
	}
	// 등록
	@RequestMapping("/scoreRegist")
	public String scoreRegist() {
		return "service/scoreRegist";
	}
	
	// 폼 요청
	@RequestMapping(value="/scoreForm", method=RequestMethod.POST)
	public String scoreForm(ScoreVO vo) { // 값 받기
		
		scoreService.regist(vo);
		
		return "service/scoreResult";
	}
	
	// 삭제 요청
	@RequestMapping("/deleteScore")
	public String deleteScore(@RequestParam("sno") int sno) {
		// 먼저 삭제 버튼에 인덱스부터 만들어 줘야 함 - scoreList.jsp로!
		
		// service 인터페이스 가서 삭제 추상 메소드 추가 - 구현 클래스 오버라이딩 - DAO도 동일하게 추상 메소드 추가 - impl 오버라이딩
		scoreService.delete(sno); // 서비스 호출

//		return "service/scoreList"; 이렇게 쓰면 데이터를 화면으로 못 들고 나감
		return "redirect:/service/scoreList"; // 데이터 들고 나가려면 컨트롤러에 태워야 하니까 redirect 써야 함
		// * 참고 : 컨트롤러 경로는 서블릿이 알아서 잘라다 씀 *
	}
	
}