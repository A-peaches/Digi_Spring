package kr.soft.study;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println(signatureStr + "is start.");
		long st = System.currentTimeMillis();
		
		try {
		Object obj = joinpoint.proceed(); //�̺κп��� �޼��尡 ����.
		return obj;
		} finally {
			long et = System.currentTimeMillis();
			System.out.println(signatureStr + " is finished.");
			System.out.println(signatureStr + " ����ð� : " + (et-st));
		}
	}
	
	public void beforeAdvice(JoinPoint joinpoint) {
		System.out.println("beforAdvice()");
	}
	
	public void afterReturningAdvice(JoinPoint joinpoint) {
		System.out.println("afterReturningAdvice()");
	}
	
	public void afterThrowingAdvice(JoinPoint joinpoint) {
		System.out.println("afterThrowingAdvice()");
	}
	
	public void afterAdvice(JoinPoint joinpoint) {
		System.out.println("afterAdvice()");
	}
	
}
