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
		
		String configLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		MyCalculator myCalculator = ctx.getBean("myCalculator",MyCalculator.class);
		
		myCalculator.add();
		myCalculator.sub();
		myCalculator.mul();
		myCalculator.div();
	}
}
