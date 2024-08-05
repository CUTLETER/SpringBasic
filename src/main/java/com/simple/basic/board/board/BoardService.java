package com.simple.basic.board.board;

import java.util.ArrayList;

import com.simple.basic.command.BoardVO;

public interface BoardService {
	
	public void regist(BoardVO vo);
	public ArrayList<BoardVO> getPost();
	public void delete(int num);

}
