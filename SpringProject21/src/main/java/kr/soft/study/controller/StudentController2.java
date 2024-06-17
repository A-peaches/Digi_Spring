package kr.soft.study.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.soft.study.student2.Student;
import kr.soft.study.student2.StudentValidator;

@Controller
@RequestMapping("/student2")
public class StudentController2 {
	
	
	@RequestMapping(value= "/insert")
	public String insert() {
		return "student2/createPage";
	}
	
	// ver1
//	@RequestMapping(value= "/result", method= RequestMethod.POST)
//	public String result(Student student, BindingResult result) {
//		
//		String page = "student2/createDonePage";
//		
//		StudentValidator validator = new StudentValidator();
//		validator.validate(student, result);
//		if(result.hasErrors()) {
//			page = "student2/createPage";
//		}
//		
//		return page;
//	}
	
	
	//ver2
	@RequestMapping(value= "/result", method= RequestMethod.POST)
	public String result(@Valid Student student, BindingResult result) {
		
		String page = "student2/createDonePage";
		
		if(result.hasErrors()) {
			page = "student2/createPage";
		}
		
		return page;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new StudentValidator());
	}
}
