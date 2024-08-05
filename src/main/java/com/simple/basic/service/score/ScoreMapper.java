package com.simple.basic.service.score;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.simple.basic.command.ScoreVO;

@Mapper
public interface ScoreMapper {

	public void regist(ScoreVO vo);
	public ArrayList<ScoreVO> getScore();
	public void delete(int sno);
}
