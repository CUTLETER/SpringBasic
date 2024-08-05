package com.simple.basic.board.board;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.simple.basic.command.BoardVO;

@Mapper
public interface BoardMapper {

	public void regist(BoardVO vo);
	public ArrayList<BoardVO> getPost();
	public void delete(int num);

}
