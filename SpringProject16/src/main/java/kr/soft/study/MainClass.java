package kr.soft.study;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String args[]) {
		
		String config = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("어떤 걸 사용하시겠어요?");
		String str = sc.next();
		if(str.equals("dev")) {
			config = "dev";
		} else if(str.equals("run")) {
			config = "run";
		}
		
		sc.close();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.load("applicationCTX_dev.xml","applicationCTX_run.xml");
		
		ServerInfo info = ctx.getBean("serverInfo",  ServerInfo.class);
		System.out.println("IP : " + info.getIpNum());
		System.out.println("port : " + info.getPortNum());

		ctx.close();
	}
}
