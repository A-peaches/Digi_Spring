package kr.soft.study;


import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:applicationCTX.xml")
public class ApplicationConfig {

	@Bean 
	public Student student1() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("����");
		hobbys.add("����");
		
		Student student = new Student("������",hobbys);
		
		return student;
	}
	

	@Bean 
	public StudentInfo studentInfo1() {
		
		StudentInfo studentInfo = new StudentInfo(student1());
		
		return studentInfo;
	}
	
	@Bean
	public Family family() {
		Family family = new Family("�Ɩ�","�ȸ�","�´�","����");
		
		return family;
	}
	
	
}
