package com.simple.basic.service.score.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simple.basic.command.ScoreVO;

@Repository("y") // component-scan 필수
public class ScoreDAOImple implements ScoreDAO {
	
	
	// DB (..라고 가정)
	ArrayList<ScoreVO> list = new ArrayList<>();

	@Override
	public void regist(ScoreVO vo) {
		// TODO Auto-generated method stub
//		System.out.println("repository layer : "+vo);
		list.add(vo); // insert 완료
	}

	@Override
	public ArrayList<ScoreVO> getScore() {
		// TODO Auto-generated method stub
		return list;
	}

	
}
