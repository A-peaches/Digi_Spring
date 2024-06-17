package kr.soft.study.controller;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.soft.study.member.JoinData;
import kr.soft.study.member.JoinValidator;
import kr.soft.study.student2.Student;
import kr.soft.study.student2.StudentValidator;

@Controller
@RequestMapping("/join")
public class JoinController2 {
	
	@RequestMapping("/joinView")
	public String joinView() {   

		return "join/joinView";

	}
	
	// ver 1. Model 객체, POST 방식, HttpServletRequest
//	@RequestMapping(value = "/joinResult", method = RequestMethod.POST)
//	public String joinResult(HttpServletRequest httpServletRequest, Model model) {   
//		
//		String id = httpServletRequest.getParameter("id");
//		String pw = httpServletRequest.getParameter("pw");
//		String email = httpServletRequest.getParameter("email");
//		String name = httpServletRequest.getParameter("name");
//		String idNo = httpServletRequest.getParameter("idNo");
//		int year = Integer.parseInt(httpServletRequest.getParameter("year"));
//		int month = Integer.parseInt(httpServletRequest.getParameter("month"));
//		int day = Integer.parseInt(httpServletRequest.getParameter("day"));
//		String habits[] = httpServletRequest.getParameterValues("habit");
//		String habit = "";
//		for(String hb : habits) {
//			habit += hb +" ";
//		}
//		String myInfo = httpServletRequest.getParameter("myInfo");
//		
//		JoinData joinData = new JoinData(id,pw,email,name,idNo, year,month,day,habit,myInfo);
//		model.addAttribute("joinData",joinData);
//		
//		return "join/joinResult";
//
//	}
	
	// ver 2. POST 방식, joindata 객체를 매개변수로.
//		@RequestMapping(value = "/joinResult", method = RequestMethod.POST)
//		public String joinResult(JoinData joinData) {   
//			
//			return "join/joinResult";
//
//		}
		
	// ver 3. POST 방식, joindata 객체를 매개변수로.
//		@RequestMapping(value = "/joinResult", method = RequestMethod.POST)
//		public ModelAndView joinResult(JoinData joinData) {   
//			ModelAndView mv = new ModelAndView();
//			mv.addObject("joinData",joinData);
//			mv.setViewName("join/joinResult");
//			
//			return mv;
//
//		}
		
//	// ver 4. POST 방식, 어노테이션방식, ModelAndView
//		@RequestMapping(value = "/joinResult", method = RequestMethod.POST)
//		public ModelAndView joinResult(@RequestParam String id,@RequestParam String pw,
//				@RequestParam String email, @RequestParam String name, @RequestParam String idNo,
//				@RequestParam int year, @RequestParam int month, @RequestParam int day,
//				@RequestParam String[] habit, @RequestParam String myInfo
//				) {   
//			String habitStr = "";
//			for(String hb : habit) {
//				habitStr += hb + " ";
//			}
//			
//			ModelAndView mv = new ModelAndView();
//			JoinData joinData = new JoinData(id,pw,email,name,idNo, year,month,day,habitStr,myInfo);
//			
//			mv.addObject("joinData",joinData);
//			mv.setViewName("join/joinResult");
//
//			return mv;
//
//		}
//		
	
//		//ver1. 데이터 유효성 검사 
//		@RequestMapping(value = "/joinResult", method = RequestMethod.POST)
//		public String joinResult(JoinData joinData, BindingResult result) {   
//			
//			String page = "join/joinResult";
//			
//			JoinValidator validator = new JoinValidator();
//			validator.validate(joinData, result);
//			
//			if(result.hasErrors()) {
//				page = "join/joinView";
//			}
//			
//			return page;
//	
//		}
//		
		//ver2
		@RequestMapping(value= "/joinResult", method= RequestMethod.POST)
		public String result(@Valid Student student, BindingResult result) {
			
			String page = "join/joinResult";
			
			if(result.hasErrors()) {
				page = "join/joinView";
			}
			
			return page;
		}
		
		@InitBinder
		protected void initBinder(WebDataBinder binder) {
			binder.setValidator(new JoinValidator());
		}
}
