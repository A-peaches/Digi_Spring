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

@Aspect
public class LogAop_Annotation {
	
//  @Pointcut("within(kr.soft.study.*)") // kr.soft.study ��Ű�� �ȿ� �ִ� ��� �޼ҵ�
//  @Pointcut("within(kr.soft.study.ex..*)") // kr.soft.study ��Ű�� �� ���� ��Ű�� �ȿ� �ִ� ��� �޼ҵ� 
//  @Pointcut("within(kr.soft.study.Worker)") // kr.soft.study.Worker ��� �޼ҵ� 
//  
//  @Pointcut("bean(*ker)") // -ker�� ������ �󿡸� ���� 
//  @Pointcut("bean(student)") // student �󿡸� ���� 
//  
//  @Pointcut("execution(public void get*(..))") // public void�� ��� get �޼ҵ忡�� ���� 
//  @Pointcut("execution(* kr.soft.study.*.*())") // kr.soft.study ��Ű���� �Ķ���Ͱ� ���� ��� �޼ҵ�   
//  @Pointcut("execution(* kr.soft.study..*.*())") // kr.soft.study ��Ű�� & kr.soft.study ���� ��Ű���� �Ķ���Ͱ� ���� ��� �޼ҵ�
//  @Pointcut("execution(* kr.soft.study.Worker.*())") // kr.soft.study.Worker ���� ��� �޼ҵ� 
	
	@Pointcut("within(kr.soft.study..*)")
	private void pointcutMethod() {
	}
	
	//@Around("within(kr.soft.study.*)")
	@Around("pointcutMethod()")
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
	
	@Before("pointcutMethod()")
	public void beforeAdvice(JoinPoint joinpoint) {
		System.out.println("beforAdvice()");
	}
	
	@AfterReturning("pointcutMethod()")
	public void afterReturning(JoinPoint joinpoint) {
		System.out.println("afterReturning()");
	}
	
	@AfterThrowing("pointcutMethod()")
	public void afterThrowing(JoinPoint joinpoint) {
		System.out.println("afterThrowing()");
	}
	
	@After("pointcutMethod()")
	public void after(JoinPoint joinpoint) {
		System.out.println("after()");
	}
	

}
