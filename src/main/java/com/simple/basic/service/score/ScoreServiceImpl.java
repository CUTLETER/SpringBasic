package com.simple.basic.service.score;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.simple.basic.command.ScoreVO;
import com.simple.basic.service.score.impl.ScoreDAO;

@Service("x") // 반드시 component-scan에 의해 읽혀야 함
public class ScoreServiceImpl implements ScoreService {
	
	@Autowired
	@Qualifier("y")
	ScoreDAO scoreDAO;
	
	@Override
	public void regist(ScoreVO vo) {
		scoreDAO.regist(vo);
	}

	@Override
	public ArrayList<ScoreVO> getScore() {
//		ArrayList<ScoreVO> list = scoreDAO.getScore();
//		return list; 아래는 좀 더 간단하게
		return scoreDAO.getScore();
	}

}
