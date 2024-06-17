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
		String myName = "����";
		model.addAttribute("myName", myName );
		return "board/view";
	}
	
	@RequestMapping("/content")
	public String content(Model model) {   
		// �� ��ü�� �ڵ����� �������ش�. ���� �����͸� ��� �׸��̴�.
		
		String id = "30";
		model.addAttribute("id", id );
		return "board/content";
	}
	
	@RequestMapping("/reply")
	public ModelAndView reply() {   
		
		// Model And View�� Model�� View������ ��� ��� �ִ� ��ü�̴�.
		ModelAndView mv = new ModelAndView();
		mv.addObject("id",500);
		mv.setViewName("board/reply");
		
		return mv;
	}
	
	@RequestMapping("/confirmId")
	public String confirmId(HttpServletRequest httpServletRequest, Model model) {   
		//http://localhost:8081/study/board/confirmId?id=����&pw=1234
		String id = httpServletRequest.getParameter("id");
		String pw = httpServletRequest.getParameter("pw");		
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		
		return "board/confirmId";

	}
	
	@RequestMapping("/checkId")
	public String checkId(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {   
		//������̼��� Ȱ���ϸ� �ڵ尡 �������� ��������(?) = ª������
		//http://localhost:8081/study/board/checkId?id=����&pw=1234
		model.addAttribute("identify",id);
		model.addAttribute("password",pw);
		
		return "board/checkId";

	}
	

}
