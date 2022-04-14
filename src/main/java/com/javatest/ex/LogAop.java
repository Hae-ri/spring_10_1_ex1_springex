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
	//@Pointcut("bean(*ker)") // *ker�� ������ �̸��� ���� �󿡸� advice ���� 
	@Pointcut("bean(student)") // *student �󿡸� advice ���� 
	private void pointcutMethod() {
	}
	
	@Around("pointcutMethod()")
	public Object loggerAop(ProceedingJoinPoint joinPoint) throws Throwable {
		
		String signatureStr = joinPoint.getSignature().toShortString(); // Ÿ�� �޼����� signature ����
		System.out.println(signatureStr + "�޼��尡 ���۵Ǿ����ϴ�.");
		long st = System.currentTimeMillis(); // �޼��� ȣ�� �� ���� �ð��� long�� ������ ����
		
		try {
			Object obj = joinPoint.proceed(); // Ÿ���� �޼���(�ٽ� ���)�� ȣ��
			return obj;
		}finally {
			long et = System.currentTimeMillis(); // �޼��� ȣ�� �� ���� �ð�
			System.out.println(signatureStr + "�޼��尡 ����Ǿ����ϴ�.");
			System.out.println(signatureStr + "�޼����� �۾� ����ð� : " + (et - st) + "ms" );
		}
	}
	
	@Before("within(com.javatest.ex.*)")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("beforeAdvice ����" );
	}
	
	//@AfterReturning("within(com.javatest.ex.*)")
	public void afterReturnAdvice(JoinPoint joinPoint) {
		System.out.println("afterReturnAdvice ����" );
	}
	
	//@AfterThrowing("within(com.javatest.ex.*)")
	public void afterThrowAdivce(JoinPoint joinPoint) {
		System.out.println("afterThrowAdivce ����" );
	}
	
	//@After("within(com.javatest.ex.*)")
	public void afterAdivce(JoinPoint joinPoint) {
		System.out.println("afterAdivce ����" );
	}
		
}