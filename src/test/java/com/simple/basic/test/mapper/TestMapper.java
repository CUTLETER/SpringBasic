package com.simple.basic.test.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper // 웬만하면 뚜껑 달아주기
public interface TestMapper {
	
	public String getTime();
}
