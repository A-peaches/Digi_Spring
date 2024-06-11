package kr.soft.study;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


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
		System.out.println("student��ü ������....");
	}
	

	public void afterReturning(JoinPoint joinpoint) {
		System.out.println("afterReturning()");
	}
	

	public void afterThrowing(JoinPoint joinpoint) {
		System.out.println("afterThrowing()");
	}
	

	public void afterAdvice(JoinPoint joinpoint) {
		System.out.println("getWorkerInfo() ȣ�� �Ϸ�....");
	}
	

}
