package kr.soft.study;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainClass {
	
	public static void main(String[] args) {
		// ConfigurableApplicationContext�� ����� ������ ���ø����̼� ���ؽ�Ʈ ����
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		
		// ������ ���ؽ�Ʈ���� Environment ��ü�� ������
		ConfigurableEnvironment env = ctx.getEnvironment();
		
		// Environment ��ü���� MutablePropertySources ��ü�� ������
		MutablePropertySources propertySources = env.getPropertySources();
		
		try {
			// admin.properties ������ propertySources�� �߰�
			propertySources.addLast(new ResourcePropertySource("classpath:admin.properties"));
			
			// admin.properties ���Ͽ��� admin.id�� admin.pw �Ӽ��� �о�� ���
			System.out.println(env.getProperty("admin.id"));
			System.out.println(env.getProperty("admin.pw"));
		} catch (IOException e) {
			// IOException�� �߻��ϸ� catch ��Ͽ��� ó�� (���⼭�� �ƹ� �۾��� ���� ����)
		}
		
		// GenericXmlApplicationContext�� ctx ��ü�� ĳ����
		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx;
		
		// applicationCTX.xml ���� ������ �ε�
		gCtx.load("applicationCTX.xml");
		
		// ���ؽ�Ʈ�� �����Ͽ� ���� �ʱ�ȭ
		gCtx.refresh();
		
		// adminConnection ���� ������ AdminConnection Ÿ���� ��ü�� �ʱ�ȭ
		AdminConnection adminConnection = gCtx.getBean("adminConnection", AdminConnection.class);
		
		// adminConnection ��ü�� adminId�� adminPw �Ӽ� ���� ���
		System.out.println("admin ID : " + adminConnection.getAdminId());
		System.out.println("admin PW : " + adminConnection.getAdminPw());
		
		// ���ؽ�Ʈ�� �ݾ� �ڿ� ����
		gCtx.close();
		ctx.close();
	}
}
