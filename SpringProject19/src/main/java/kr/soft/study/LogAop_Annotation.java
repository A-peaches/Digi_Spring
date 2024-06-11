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
	
//  @Pointcut("within(kr.soft.study.*)") // kr.soft.study 패키지 안에 있는 모든 메소드
//  @Pointcut("within(kr.soft.study.ex..*)") // kr.soft.study 패키지 및 하위 패키지 안에 있는 모든 메소드 
//  @Pointcut("within(kr.soft.study.Worker)") // kr.soft.study.Worker 모든 메소드 
//  
//  @Pointcut("bean(*ker)") // -ker로 끝나는 빈에만 적용 
//  @Pointcut("bean(student)") // student 빈에만 적용 
//  
//  @Pointcut("execution(public void get*(..))") // public void인 모든 get 메소드에만 적용 
//  @Pointcut("execution(* kr.soft.study.*.*())") // kr.soft.study 패키지에 파라미터가 없는 모든 메소드   
//  @Pointcut("execution(* kr.soft.study..*.*())") // kr.soft.study 패키지 & kr.soft.study 하위 패키지에 파라미터가 없는 모든 메소드
//  @Pointcut("execution(* kr.soft.study.Worker.*())") // kr.soft.study.Worker 안의 모든 메소드 
	
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
		Object obj = joinpoint.proceed(); //이부분에서 메서드가 동작.
		return obj;
		} finally {
			long et = System.currentTimeMillis();
			System.out.println(signatureStr + " is finished.");
			System.out.println(signatureStr + " 경과시간 : " + (et-st));
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
