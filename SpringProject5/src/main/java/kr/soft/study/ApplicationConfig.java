package kr.soft.study;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	@Bean 
	public Student student1() {
		Student student = new Student("pipi","3��","1�г�","10��");
		return student;
	}
	
	@Bean 
	public Student student2() {
		Student student = new Student("cici","2��","2�г�","12��");
		return student;
	}
	
	@Bean 
	public StudentInfo studentInfo() {
		StudentInfo studentInfo = new StudentInfo(student1());
		
		return studentInfo;
	}
}
