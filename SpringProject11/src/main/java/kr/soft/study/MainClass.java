package kr.soft.study;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String args[]) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(); //생성
		
		ctx.load("classpath:applicationCTX.xml");
		
		ctx.refresh();
		
		Student student = ctx.getBean("student", Student.class);
		System.out.println("이름 : " + student.getName());
		System.out.println("나이 : " + student.getAge());

		OtherStudent student2 = ctx.getBean("student2", OtherStudent.class);
		System.out.println("이름 : " + student2.getName());
		System.out.println("나이 : " + student2.getAge());

		ctx.close(); //종료
		
		//안나옴! 빈즈소멸.
//		System.out.println("이름 : " + student.getName());
//		System.out.println("나이 : " + student.getAge());
	}
}
