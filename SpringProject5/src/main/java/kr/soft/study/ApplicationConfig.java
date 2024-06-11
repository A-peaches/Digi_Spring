package kr.soft.study;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    // student1 빈을 정의합니다. "pipi"라는 이름을 가진 Student 객체를 생성합니다.
    @Bean 
    public Student student1() {
        Student student = new Student("pipi", "3살", "1학년", "10번");
        return student;
    }
    
    // student2 빈을 정의합니다. "cici"라는 이름을 가진 Student 객체를 생성합니다.
    @Bean 
    public Student student2() {
        Student student = new Student("cici", "2살", "2학년", "12번");
        return student;
    }
    
    // studentInfo 빈을 정의합니다. student1 빈을 주입받아 StudentInfo 객체를 생성합니다.
    @Bean 
    public StudentInfo studentInfo() {
        StudentInfo studentInfo = new StudentInfo(student1());
        return studentInfo;
    }
}
