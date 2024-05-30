package kr.soft.study;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	@Bean 
	public Student student1() {
		Student student = new Student("pipi","3살","1학년","10번");
		return student;
	}
	
	@Bean 
	public Student student2() {
		Student student = new Student("cici","2살","2학년","12번");
		return student;
	}
	
	@Bean 
	public StudentInfo studentInfo() {
		StudentInfo studentInfo = new StudentInfo(student1());
		
		return studentInfo;
	}
}
