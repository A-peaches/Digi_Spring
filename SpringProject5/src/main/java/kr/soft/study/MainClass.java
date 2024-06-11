package kr.soft.study;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String args[]) {
		
//		String configLocation = "classpath:applicationCTX.xml";
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
//		ApplicationConfig Ŭ���� ������ ���ø����̼� ���ؽ�Ʈ �� ��ü�� �ƴ�����, 
//		���ø����̼� ���ؽ�Ʈ�� �����ϴ� ���� ������ �����մϴ�. 
//		AnnotationConfigApplicationContext�� �� ���� Ŭ������ ����Ͽ� ���ؽ�Ʈ�� �ʱ�ȭ�ϰ�, ����� �����մϴ�
		AnnotationConfigApplicationContext ctx 
		= new AnnotationConfigApplicationContext(ApplicationConfig.class);

		StudentInfo studentInfo = ctx.getBean("studentInfo",StudentInfo.class);
		studentInfo.getStudentInfo();
		
		Student student2 = ctx.getBean("student2",Student.class);
		studentInfo.setStudent(student2);
		studentInfo.getStudentInfo();
	}
}

