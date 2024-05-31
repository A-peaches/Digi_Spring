package kr.soft.study;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String args[]) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(); //����
		
		ctx.load("classpath:applicationCTX.xml");
		
		ctx.refresh();
		
		Student student = ctx.getBean("student", Student.class);
		System.out.println("�̸� : " + student.getName());
		System.out.println("���� : " + student.getAge());

		OtherStudent student2 = ctx.getBean("student2", OtherStudent.class);
		System.out.println("�̸� : " + student2.getName());
		System.out.println("���� : " + student2.getAge());

		ctx.close(); //����
		
		//�ȳ���! ����Ҹ�.
//		System.out.println("�̸� : " + student.getName());
//		System.out.println("���� : " + student.getAge());
	}
}
