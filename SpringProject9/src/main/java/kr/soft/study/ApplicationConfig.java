package kr.soft.study;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //������ ������ ���Ǵ� Ŭ����.
public class ApplicationConfig {
	
	@Bean //�������
	public Student student1() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("������ �Ա�");
		hobbys.add("������ �׸���");
		
		Student student = new Student("������",5,hobbys);
		student.setHeight(30);
		student.setWeight(1);
		
		return student;
	}
	
	
//	@Bean //�������
//	public Student student2() {
//		ArrayList<String> hobbys = new ArrayList<String>();
//		hobbys.add("������ Ű���");
//		hobbys.add("������ ������ ���");
//		
//		Student student = new Student("��ġġ",4,hobbys);
//		student.setHeight(28);
//		student.setWeight(0.5);
//		
//		return student;
//	}
	
}
