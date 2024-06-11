package kr.soft.study;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("run")
public class ApplicationConfigRun {
	
	@Bean
	public ServerInfo serverInfo() {
		ServerInfo info = new ServerInfo();
		info.setIpNum("192.168.0.70");
		info.setPortNum("80");
		return info;
	}
	
}
