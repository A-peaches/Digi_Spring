package kr.soft.study;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String args[]) {
		String configLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
	    // xml���� myInfo ��ü�� �����ͼ� myInfo ���۷��� ������ ����ϴ�.
        // ctx ��ü�� �����԰� ���ÿ� applicationCTX.xml�� ���ǵ� ����� �ʱ�ȭ�˴ϴ�.
        // getBean�� ���� ���ؽ�Ʈ���� myInfo ���� ������ �� �ֽ��ϴ�.
		MyInfo myInfo = ctx.getBean("myInfo",MyInfo.class);
		myInfo.getInfo();
		ctx.close();
	}
}
