package kr.soft.study;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //스프링 설정에 사용되는 클래스.
public class ApplicationConfig {
	
	@Bean //나빈즈양
	public Student student1() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("복숭아 먹깅");
		hobbys.add("복숭아 그리기");
		
		Student student = new Student("김피피",5,hobbys);
		student.setHeight(30);
		student.setWeight(1);
		
		return student;
	}
	
	
//	@Bean //나빈즈양
//	public Student student2() {
//		ArrayList<String> hobbys = new ArrayList<String>();
//		hobbys.add("복숭아 키우기");
//		hobbys.add("복숭아 가지구 놀기");
//		
//		Student student = new Student("김치치",4,hobbys);
//		student.setHeight(28);
//		student.setWeight(0.5);
//		
//		return student;
//	}
	
}
