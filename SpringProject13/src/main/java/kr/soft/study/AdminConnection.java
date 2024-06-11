package kr.soft.study;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class AdminConnection implements EnvironmentAware, InitializingBean, DisposableBean{
	// 인터페이스 설명
	// EnvironmentAware 인퍼페이스는 setEnvironment 메서드를 통해 Environment 객체를 주입받을 수 있게합니다.
	// InitializingBean 인터페이스는 빈의 모든 속성이 설정된 후에 호출되는 afterPropertiesSet 메서드를 제공합니다.
	// DisposableBean 인터페이스는 빈이 소멸될 때 호출되는 'destory' 메서드를 제공합니다.
	
	private Environment env;
	private String adminId;
	private String adminPw;
	
	//default constructor
	public AdminConnection() {
	}

	@Override
	public void destroy() throws Exception { // 빈이 소멸될 때 호출
		System.out.println("destory()");
	}

	@Override
	public void afterPropertiesSet() throws Exception { // 빈의 모든 속성이 설정된 후에 호출
		System.out.println("afterPropertiesSet()");
		setAdminId(env.getProperty("admin.id"));
		setAdminPw(env.getProperty("admin.pw"));
	}

	@Override
	public void setEnvironment(Environment env) { //Environment 객체 주입 
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
