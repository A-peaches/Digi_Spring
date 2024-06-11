package kr.soft.study;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
	public static void main(String args[]) {
		
		String config = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("� �� ����Ͻðھ��?");
		String str = sc.next();
		if(str.equals("dev")) {
			config = "dev";
		} else if(str.equals("run")) {
			config = "run";
		}
		
		sc.close();
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.register(ApplicationConfigDev.class, ApplicationConfigRun.class);
		ctx.refresh();
		
		ServerInfo info = ctx.getBean("serverInfo",  ServerInfo.class);
		System.out.println("==========================");
		System.out.println("IP : " + info.getIpNum());
		System.out.println("port : " + info.getPortNum());
		System.out.println("==========================");
		
		ctx.close();
	}
}
