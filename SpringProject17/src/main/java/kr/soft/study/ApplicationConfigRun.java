package kr.soft.study;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration // 이 클래스가 스프링 설정 클래스임을 나타냄
@Profile("run") // 이 설정 클래스는 "run" 프로파일이 활성화된 경우에만 적용됨
public class ApplicationConfigRun {
	
    @Bean // 이 메서드가 스프링 컨테이너에 의해 관리되는 빈 정의 메서드임을 나타냄
    public ServerInfo serverInfo() {
        ServerInfo info = new ServerInfo(); // ServerInfo 객체 생성
        info.setIpNum("123.456.7.89"); // ipNum 속성을 "123.456.7.89"로 설정
        info.setPortNum("10"); // portNum 속성을 "10"으로 설정
        return info; // 초기화된 ServerInfo 객체를 반환하여 빈으로 등록
    }
}
