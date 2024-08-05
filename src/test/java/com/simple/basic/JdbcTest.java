package com.simple.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simple.basic.test.mapper.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class) // JUnit을 스프링 테스트 코드로 실행시킨다는 의미
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/root-context.xml") // 괄호 안에 동작시킬 스프링 설정 파일의 경로를 넣어주면 됨
public class JdbcTest {
	
	
	// DB 연결
	@Autowired
	DataSource ds; // root-context.xml에 선언되어 있는 DB 정보 담은 객체
	
//	@Autowired
//	SqlSessionFactory sqlSessionFactory;

	@Autowired
 	TestMapper testMapper;
	
//	@Test // test 코드로 동작함
	public void testCode01() {
		try {
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT SYSDATE AS TIME FROM DUAL");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String time = rs.getString("time");
				System.out.println(time);
			}
			
			conn.close();
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}

	@Test
	public void testCode02() {
		String time = testMapper.getTime();
		System.out.println(time);
	}
}
