package kr.soft.study;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class ApplicationConfig {
	
	//properties에 등록된 Value 값을 쓸거라고 지정.
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
		PropertySourcesPlaceholderConfigurer configurer
						= new PropertySourcesPlaceholderConfigurer();
		
		Resource[] locations = new Resource[2]; // 리소스가 여러가지이기때문에 배열로 선언
		locations[0] = new ClassPathResource("admin.properties");
		locations[1] = new ClassPathResource("sub_admin.properties");
		configurer.setLocations(locations);
		
		return configurer;
	}
	
	@Bean
	public AdminConnection adminConfig() {
		AdminConnection adminConnection = new AdminConnection();
		adminConnection.setAdminId(adminId);
		adminConnection.setAdminPw(adminPw);
		adminConnection.setSub_adminId(sub_adminId);
		adminConnection.setSub_adminPw(sub_adminPw);
		
		return adminConnection;
	}
}
