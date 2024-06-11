package kr.soft.study;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String args[]) {
		
//		String configLocation = "classpath:applicationCTX.xml";
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
//		ApplicationConfig 클래스 파일이 애플리케이션 컨텍스트 그 자체는 아니지만, 
//		애플리케이션 컨텍스트를 구성하는 설정 정보를 제공합니다. 
//		AnnotationConfigApplicationContext는 이 설정 클래스를 사용하여 컨텍스트를 초기화하고, 빈들을 관리합니다
		AnnotationConfigApplicationContext ctx 
		= new AnnotationConfigApplicationContext(ApplicationConfig.class);

		StudentInfo studentInfo = ctx.getBean("studentInfo",StudentInfo.class);
		studentInfo.getStudentInfo();
		
		Student student2 = ctx.getBean("student2",Student.class);
		studentInfo.setStudent(student2);
		studentInfo.getStudentInfo();
	}
}

