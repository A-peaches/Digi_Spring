package kr.soft.study;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
//		MyCalculator myCal = new MyCalculator();
//		myCal.setCalculator(new Calculator());
//
//		myCal.setFirstNum(10);
//		myCal.setSecondNum(2);
//
//		myCal.add();
//		myCal.sub();
//		myCal.mul();
//		myCal.div();
		
		String configLocation = "classpath:applicationCTX.xml"; //설정 파일의 경로를 지정
		
		//XML 파일을 사용하여 Spring 애플리케이션 컨텍스트 초기화
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
		//설정 파일에서 정의된 myCalculator 빈을 가져와서 myCalculator 레퍼런스 변수에 주입.
		MyCalculator myCalculator = ctx.getBean("myCalculator",MyCalculator.class);
		
		myCalculator.add();
		myCalculator.sub();
		myCalculator.mul();
		myCalculator.div();
	}
}
