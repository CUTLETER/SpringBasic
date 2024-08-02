package com.simple.basic.service.score.impl;

import java.util.ArrayList;

import com.simple.basic.command.ScoreVO;

public interface ScoreDAO {

	public void regist(ScoreVO vo);
	public ArrayList<ScoreVO> getScore();
}
