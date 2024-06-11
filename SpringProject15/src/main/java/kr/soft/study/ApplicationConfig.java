package kr.soft.study;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration // 이 클래스가 스프링 설정 클래스임을 나타냄
public class ApplicationConfig {

	// properties 파일에 정의된 값을 주입받는 필드
	@Value("${admin.id}")
	private String adminId;

	@Value("${admin.pw}")
	private String adminPw;

	@Value("${sub_admin.id}")
	private String sub_adminId;

	@Value("${sub_admin.pw}")
	private String sub_adminPw;

	@Bean
	public static PropertySourcesPlaceholderConfigurer Properties() {
		// PropertySourcesPlaceholderConfigurer 빈을 생성하여 반환
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();

		// 리소스 배열을 생성하여 여러 properties 파일을 지정
		Resource[] locations = new Resource[2];
		locations[0] = new ClassPathResource("admin.properties");
		locations[1] = new ClassPathResource("sub_admin.properties");

		// configurer에 properties 파일 위치를 설정
		configurer.setLocations(locations);

		// 설정된 configurer를 반환
		return configurer;
	}

	@Bean
	public AdminConnection adminConfig() {
		// AdminConnection 빈을 생성하여 반환
		AdminConnection adminConnection = new AdminConnection();

		// adminConnection 빈에 주입받은 properties 값을 설정
		adminConnection.setAdminId(adminId);
		adminConnection.setAdminPw(adminPw);
		adminConnection.setSub_adminId(sub_adminId);
		adminConnection.setSub_adminPw(sub_adminPw);

		// 설정된 adminConnection 빈을 반환
		return adminConnection;
	}
}
