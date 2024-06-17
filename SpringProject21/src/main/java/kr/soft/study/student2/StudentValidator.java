package kr.soft.study.student2;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> arg0) {
		return Student.class.isAssignableFrom(arg0);
	}

	// ver1
//	@Override
//	public void validate(Object obj, Errors errors) {
//		System.out.println("validate()");
//		Student student = (Student)obj;
//		
//		String studentName = student.getName();
//		if(studentName == null || studentName.trim().isEmpty()) {
//			System.out.println("studentName is null or empty");
//			errors.rejectValue("name", "trouble");
//		}
//		
//		String studentId = student.getId();
//		if(studentId == null || studentId.trim().isEmpty()) {
//			System.out.println("studentId is null");
//			errors.rejectValue("id", "trouble");
//		}
//	}
	
	// ver 2
	@Override
	public void validate(Object obj, Errors errors) {
		System.out.println("validate()");
		Student student = (Student)obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "trouble");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "trouble");
		
	}

}
