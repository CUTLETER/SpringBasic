package com.simple.basic.service.score;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.simple.basic.command.ScoreVO;
import com.simple.basic.service.score.impl.ScoreDAO;

@Service("x") // 반드시 component-scan에 의해 읽혀야 함
public class ScoreServiceImpl implements ScoreService {
	
// mybatis 연결로 dao 필요 없어짐	
//	@Autowired
//	@Qualifier("y")
//	ScoreDAO scoreDAO;
	
	@Autowired
	private ScoreMapper scoreMapper;
	
	@Override
	public void regist(ScoreVO vo) {
//		scoreDAO.regist(vo);
		scoreMapper.regist(vo);
		System.out.println("regist메소드 동작");
	}

	@Override
	public ArrayList<ScoreVO> getScore() {
//		ArrayList<ScoreVO> list = scoreDAO.getScore();
//		return list; 아래는 좀 더 간단하게
//		return scoreDAO.getScore();
		System.out.println("getScore메소드 동작");
		
		
		// 에러 로그를 위해 일부러 에러 발생시켜봄
//		String str = null;
//		str.charAt(0);
		
		return scoreMapper.getScore();
	}

	@Override
	public void delete(int sno) {
//		scoreDAO.delete(sno); // dao 호출
		scoreMapper.delete(sno);
		System.out.println("delete메소드 동작");
	}

}
