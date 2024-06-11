package kr.soft.study;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx 
			= new AnnotationConfigApplicationContext(ApplicationConfig.class);
		//xml이아닌 Annotation을 활용.
		
		AdminConnection connection = ctx.getBean("adminConfig",AdminConnection.class);
		
		System.out.println("adminID : " + connection.getAdminId());
		System.out.println("adminPW : " + connection.getAdminPw());
		System.out.println("sub_adminID : " + connection.getSub_adminId());
		System.out.println("sub_adminPW : " + connection.getSub_adminPw());
		
		ctx.close();		
		
	}
}
