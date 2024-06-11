package kr.soft.study;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainClass {
	
	public static void main(String[] args) {
	ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
	ConfigurableEnvironment env = ctx.getEnvironment(); //ctx��ü�� ���� �� Environment��ü�� ����������. 
	MutablePropertySources propertySources = env.getPropertySources();
	
	
	try {
		propertySources.addLast(new ResourcePropertySource("classpath:admin.properties"));
		//admin.properties���� �����͸� ����. ��ġ DBó��.
		System.out.println(env.getProperty("admin.id"));
		System.out.println(env.getProperty("admin.pw"));
	} catch (IOException e) {}

	GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx;
	gCtx.load("applicationCTX.xml");
	gCtx.refresh();
	System.out.println("applicationCTX.xml�� �ε��� �� setEnv�� after�� ���ÿ� ����ǳ���?");
	
	AdminConnection adminConnection = gCtx.getBean("adminConnection", AdminConnection.class);

	System.out.println("admin ID : " + adminConnection.getAdminId());
	System.out.println("admin PW : " + adminConnection.getAdminPw());
	
	gCtx.close();
	ctx.close();
	
	}
}
