package com.simple.basic.service.score.impl;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simple.basic.command.ScoreVO;

@Repository("y") // component-scan 필수
public class ScoreDAOImpl implements ScoreDAO {
	
	
// 	DB (..라고 가정)
//	ArrayList<ScoreVO> list = new ArrayList<>();
	
	@Autowired
	DataSource ds;
	

	@Override
	public void regist(ScoreVO vo) {
//		System.out.println("r epository layer : "+vo);
//		list.add(vo); // insert 완료
		
//		DB insert 작업
	}

	@Override
	public ArrayList<ScoreVO> getScore() {
//		return list;
//		DB select 작업
		return null;
	}

	@Override
	public void delete(int sno) {
//		list.remove(sno); // 인덱스 번호로 삭제		
//		DB remove 작업
	}

	
}
