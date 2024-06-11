package kr.soft.study;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainClass {
	
	public static void main(String[] args) {
		// ConfigurableApplicationContext를 사용해 스프링 애플리케이션 컨텍스트 생성
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		
		// 생성된 컨텍스트에서 Environment 객체를 가져옴
		ConfigurableEnvironment env = ctx.getEnvironment();
		
		// Environment 객체에서 MutablePropertySources 객체를 가져옴
		MutablePropertySources propertySources = env.getPropertySources();
		
		try {
			// admin.properties 파일을 propertySources에 추가
			propertySources.addLast(new ResourcePropertySource("classpath:admin.properties"));
			
			// admin.properties 파일에서 admin.id와 admin.pw 속성을 읽어와 출력
			System.out.println(env.getProperty("admin.id"));
			System.out.println(env.getProperty("admin.pw"));
		} catch (IOException e) {
			// IOException이 발생하면 catch 블록에서 처리 (여기서는 아무 작업도 하지 않음)
		}
		
		// GenericXmlApplicationContext로 ctx 객체를 캐스팅
		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx;
		
		// applicationCTX.xml 설정 파일을 로드
		gCtx.load("applicationCTX.xml");
		
		// 컨텍스트를 갱신하여 빈을 초기화
		gCtx.refresh();
		
		// adminConnection 빈을 가져와 AdminConnection 타입의 객체로 초기화
		AdminConnection adminConnection = gCtx.getBean("adminConnection", AdminConnection.class);
		
		// adminConnection 객체의 adminId와 adminPw 속성 값을 출력
		System.out.println("admin ID : " + adminConnection.getAdminId());
		System.out.println("admin PW : " + adminConnection.getAdminPw());
		
		// 컨텍스트를 닫아 자원 해제
		gCtx.close();
		ctx.close();
	}
}
