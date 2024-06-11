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
	ConfigurableEnvironment env = ctx.getEnvironment(); //ctx객체를 생성 후 Environment객체를 받을수있음. 
	MutablePropertySources propertySources = env.getPropertySources();
	
	
	try {
		propertySources.addLast(new ResourcePropertySource("classpath:admin.properties"));
		//admin.properties에는 데이터를 보관. 마치 DB처럼.
		System.out.println(env.getProperty("admin.id"));
		System.out.println(env.getProperty("admin.pw"));
	} catch (IOException e) {}

	GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx;
	gCtx.load("applicationCTX.xml");
	gCtx.refresh();
	System.out.println("applicationCTX.xml을 로드할 때 setEnv랑 after가 동시에 실행되나용?");
	
	AdminConnection adminConnection = gCtx.getBean("adminConnection", AdminConnection.class);

	System.out.println("admin ID : " + adminConnection.getAdminId());
	System.out.println("admin PW : " + adminConnection.getAdminPw());
	
	gCtx.close();
	ctx.close();
	
	}
}
