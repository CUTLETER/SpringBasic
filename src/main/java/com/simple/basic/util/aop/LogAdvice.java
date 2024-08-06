package com.simple.basic.util.aop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect // AOP 클래스
@Component // 이 클래스는 component-scan에 읽혀서 bean으로 생성됨
public class LogAdvice {
	
	public static final Logger log = LoggerFactory.getLogger(LogAdvice.class); // 괄호 안에 (로그 사용할 클래스명.class)
	// advice - 공통 기능
	// point cut - 내가 적용할 메소드에 advice 부착하는 행위
	// 맨앞 *은 접근 제어자
	// 중간 *은 해당 패키지 안에서 controller로 끝나는 모든 것
	// 마지막 *은 컨트롤러 안의 모든 메소드
//	@Before("execution(* com.simple.basic.controller.*Controller.*(..))")
//	@Before("execution(* com.simple.basic.service.score.ScoreServiceImpl.*(..))")
	public void beforeLog() {
		System.out.println("메소드 실행 전 동작");
	}
	
//	@After("execution(* com.simple.basic.service.score.ScoreServiceImpl.*(..))")
	public void afterLog() {
		System.out.println("메소드 실행 후 동작");
	}
	
//	@AfterThrowing(pointcut = "execution(* com.simple.basic.service.score.ScoreServiceImpl.*(..))", // pointcut = 어디에 부착할 것인가
//				   throwing = "e" // 에러를 처리할 변수명
//					)
	public void exceptionLog(Exception e) {
		System.out.println("advice 에러 로그 : "+e);
	}
	
	
	// @Around - after, before, afterThrowing 3가지를 결합해서 처리하는 어노테이션
	// 규칙 - 반환은 Object 형으로 만들고 매개변수로 실행 시점을 결정 지어줄 수 있는 ProceedingJoinPoint를 선언함
	@Around("execution(* com.simple.basic.service.score.ScoreServiceImpl.*(..))")
	public Object aroundLog(ProceedingJoinPoint jp) {
		
//		메소드로 넘어오는 매개변수 확인 가능함
//		메소드 실행되는 target 확인 가능함
//		이런 결과를 수집해서 전체 log로 찍어주거나 FileOutput을 이용해서 실행 로그 출력을 해줄 수 있음
		
		long start = System.currentTimeMillis();
		
		
		log.info("실행 클래스 : "+jp.getTarget());
		log.info("실행 메소드 : "+jp.getSignature().toString());
		log.info("매개 값 : "+Arrays.toString(jp.getArgs()));
		
	
		Object result = null;
		
		try {
			result = jp.proceed(); // 타겟 메소드의 실행
			long end = System.currentTimeMillis();
			log.info("실행 시간 : "+(end-start)*0.001);
			
			String path = "C:\\Users\\user\\Desktop\\course\\spring\\spring_log\\240806_log.txt";
			BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));
			bw.write("실행 클래스 : "+jp.getTarget()+"\n");
			bw.write("실행 메소드 : "+jp.getSignature().toString()+"\n");
			bw.write("매개 값 : "+Arrays.toString(jp.getArgs())+"\n");
			bw.write("실행 시간 : "+((end-start)*0.001)+"\n");
			bw.flush();
			bw.close();
			
		} catch (Throwable e) {
			e.printStackTrace(); // 해당 메소드에서 에러가 발생하면, 이 친구가 로그를 같이 찍음
		}
		return result; // 메소드의 정상 흐름으로 돌아감
	}
}
