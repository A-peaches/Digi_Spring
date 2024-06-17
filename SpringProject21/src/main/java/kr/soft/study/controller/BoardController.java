package kr.soft.study.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	
	@RequestMapping("/view")
	public String view(Model model) {
		String myName = "피피";
		model.addAttribute("myName", myName );
		return "board/view";
	}
	
	@RequestMapping("/content")
	public String content(Model model) {   
		// 모델 객체를 자동으로 생성해준다. 모델은 데이터를 담는 그릇이다.
		
		String id = "30";
		model.addAttribute("id", id );
		return "board/content";
	}
	
	@RequestMapping("/reply")
	public ModelAndView reply() {   
		
		// Model And View는 Model과 View정보를 모두 담고 있는 객체이다.
		ModelAndView mv = new ModelAndView();
		mv.addObject("id",500);
		mv.setViewName("board/reply");
		
		return mv;
	}
	
	@RequestMapping("/confirmId")
	public String confirmId(HttpServletRequest httpServletRequest, Model model) {   
		//http://localhost:8081/study/board/confirmId?id=피피&pw=1234
		String id = httpServletRequest.getParameter("id");
		String pw = httpServletRequest.getParameter("pw");		
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		
		return "board/confirmId";

	}
	
	@RequestMapping("/checkId")
	public String checkId(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {   
		//어노테이션을 활용하면 코드가 가독성이 좋아진다(?) = 짧아진다
		//http://localhost:8081/study/board/checkId?id=베베&pw=1234
		model.addAttribute("identify",id);
		model.addAttribute("password",pw);
		
		return "board/checkId";

	}
	

}
