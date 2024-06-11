package kr.soft.study;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration // �� Ŭ������ ������ ���� Ŭ�������� ��Ÿ��
@Profile("run") // �� ���� Ŭ������ "run" ���������� Ȱ��ȭ�� ��쿡�� �����
public class ApplicationConfigRun {
	
    @Bean // �� �޼��尡 ������ �����̳ʿ� ���� �����Ǵ� �� ���� �޼������� ��Ÿ��
    public ServerInfo serverInfo() {
        ServerInfo info = new ServerInfo(); // ServerInfo ��ü ����
        info.setIpNum("123.456.7.89"); // ipNum �Ӽ��� "123.456.7.89"�� ����
        info.setPortNum("10"); // portNum �Ӽ��� "10"���� ����
        return info; // �ʱ�ȭ�� ServerInfo ��ü�� ��ȯ�Ͽ� ������ ���
    }
}
