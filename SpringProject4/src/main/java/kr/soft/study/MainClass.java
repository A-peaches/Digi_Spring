package kr.soft.study;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String args[]) {
		String configLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
	    // xml에서 myInfo 객체를 가져와서 myInfo 레퍼런스 변수에 담습니다.
        // ctx 객체를 생성함과 동시에 applicationCTX.xml에 정의된 빈들이 초기화됩니다.
        // getBean을 통해 컨텍스트에서 myInfo 빈을 가져올 수 있습니다.
		MyInfo myInfo = ctx.getBean("myInfo",MyInfo.class);
		myInfo.getInfo();
		ctx.close();
	}
}
