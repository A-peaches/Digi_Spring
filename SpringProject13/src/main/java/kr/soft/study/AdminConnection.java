package kr.soft.study;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class AdminConnection implements EnvironmentAware, InitializingBean, DisposableBean{
	// �������̽� ����
	// EnvironmentAware �������̽��� setEnvironment �޼��带 ���� Environment ��ü�� ���Թ��� �� �ְ��մϴ�.
	// InitializingBean �������̽��� ���� ��� �Ӽ��� ������ �Ŀ� ȣ��Ǵ� afterPropertiesSet �޼��带 �����մϴ�.
	// DisposableBean �������̽��� ���� �Ҹ�� �� ȣ��Ǵ� 'destory' �޼��带 �����մϴ�.
	
	private Environment env;
	private String adminId;
	private String adminPw;
	
	//default constructor
	public AdminConnection() {
	}

	@Override
	public void destroy() throws Exception { // ���� �Ҹ�� �� ȣ��
		System.out.println("destory()");
	}

	@Override
	public void afterPropertiesSet() throws Exception { // ���� ��� �Ӽ��� ������ �Ŀ� ȣ��
		System.out.println("afterPropertiesSet()");
		setAdminId(env.getProperty("admin.id"));
		setAdminPw(env.getProperty("admin.pw"));
	}

	@Override
	public void setEnvironment(Environment env) { //Environment ��ü ���� 
		System.out.println("setEnvironment()");
		setEnv(env);
	}

	
	public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		this.env = env;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}


}
