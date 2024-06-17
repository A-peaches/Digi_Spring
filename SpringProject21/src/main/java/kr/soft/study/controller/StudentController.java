package kr.soft.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.soft.study.student.Student;
import kr.soft.study.student.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
//	@RequestMapping(value ="/studentView", method = RequestMethod.GET)
//	public String studentViewGet(@RequestParam("id") String id, Model model) {   
//		//http://localhost:8081/study/student/studentView?id=cici
//		model.addAttribute("studentId",id);
//		return "student/studentView";
//
//	}
//	
//	@RequestMapping(value ="/studentView", method = RequestMethod.POST)
//	public String studentViewPost(@RequestParam("id") String id, Model model) {   
//		//http://localhost:8081/study/student/studentView?id=cici
//		model.addAttribute("studentId",id);
//		return "student/studentView";
//
//	}
	
	
//	@RequestMapping("/studentView/{id}")
//	public String studentView(@PathVariable String id, Model model) {   
//		//http://localhost:8081/study/student/studentView/cici
//		model.addAttribute("studentId",id);
//		return "student/studentView";
//
//	}
	
//	@RequestMapping(value ="/studentView", method = RequestMethod.POST)
//	public ModelAndView studentViewPost(@ModelAttribute("stu") Student student) {   
//		
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("student",student);
//		mv.setViewName("student/studentView");
//		
//		return mv;
//
//	}
	
	@RequestMapping(value ="/")
	public String studentInsert() {   
		return "student/studentInsert";
	}
	

	@RequestMapping(value ="/studentView")
	public String studentView(@ModelAttribute("stu") Student student) {   
		
		studentService.print();
		return "student/studentView";
	}
	
	@RequestMapping(value ="/studentOk")
	public String studentOk() {   
		
		return "student/studentOk";
	}
	
	@RequestMapping(value ="/studentNg")
	public String studentNg() {   
		return "student/studentNg";
	}
	
	@RequestMapping(value ="/studentConfirm")
	public String studentConfirm(@RequestParam String id, Model model) {
		if(id.equals("abc")) {
			return "redirect:studentOk";
		} 
		
		return "redirect:studentNg";
		
	}
	
	@RequestMapping("/studentURL1")
	public String studentURL1() {
//		return "redirect:http://localhost:8081/study/WEB-INF/views/student/studentURL1.jsp";
//		servlet-context에서 출동이 나기 떄문에 에러가 발생함.
		return "redirect:http://localhost:8081/study/studentURL1.jsp";
	}
	
	@RequestMapping("/studentURL2")
	public String studentURL2() {
		return "redirect:student/studentURL2";
	}
	
	@RequestMapping("/student/studentURL2")
	public String studentURL22() {
		return "redirect:http://localhost:8081/study/studentURL2.jsp";
	}
}
