package com.javatest.ex;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop {

	//@Pointcut("within(com.javatest.ex.*)")
	//@Pointcut("bean(*ker)") // *ker로 끝나는 이름을 가진 빈에만 advice 실행 
	@Pointcut("bean(student)") // *student 빈에만 advice 실행 
	private void pointcutMethod() {
	}
	
	@Around("pointcutMethod()")
	public Object loggerAop(ProceedingJoinPoint joinPoint) throws Throwable {
		
		String signatureStr = joinPoint.getSignature().toShortString(); // 타겟 메서드의 signature 정보
		System.out.println(signatureStr + "메서드가 시작되었습니다.");
		long st = System.currentTimeMillis(); // 메서드 호출 전 현재 시간을 long형 변수에 저장
		
		try {
			Object obj = joinPoint.proceed(); // 타겟의 메서드(핵심 기능)를 호출
			return obj;
		}finally {
			long et = System.currentTimeMillis(); // 메서드 호출 후 현재 시간
			System.out.println(signatureStr + "메서드가 종료되었습니다.");
			System.out.println(signatureStr + "메서드의 작업 실행시간 : " + (et - st) + "ms" );
		}
	}
	
	@Before("within(com.javatest.ex.*)")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("beforeAdvice 실행" );
	}
	
	//@AfterReturning("within(com.javatest.ex.*)")
	public void afterReturnAdvice(JoinPoint joinPoint) {
		System.out.println("afterReturnAdvice 실행" );
	}
	
	//@AfterThrowing("within(com.javatest.ex.*)")
	public void afterThrowAdivce(JoinPoint joinPoint) {
		System.out.println("afterThrowAdivce 실행" );
	}
	
	//@After("within(com.javatest.ex.*)")
	public void afterAdivce(JoinPoint joinPoint) {
		System.out.println("afterAdivce 실행" );
	}
		
}