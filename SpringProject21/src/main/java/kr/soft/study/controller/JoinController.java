package kr.soft.study.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.soft.study.member.Member;

@Controller
@RequestMapping("/member")
public class JoinController {
	
//  ver 1.
//	@RequestMapping("/join")
//	public String join(@RequestParam("id") String id, @RequestParam("pw") String pw,
//	@RequestParam("name") String name, @RequestParam("email") String email, Model model) {   
//		//http://localhost:8081/study/member/join?name=피피&id=pipi&pw=1234&email="pipi@apeach.com"
//		model.addAttribute("name",name);
//		model.addAttribute("id",id);
//		model.addAttribute("pw",pw);
//		model.addAttribute("email",email);
//		
//		return "member/join";
//
//	}
//	

//  ver 2.
//	@RequestMapping("/join")
//	public String join(@RequestParam("id") String id, @RequestParam("pw") String pw,
//	@RequestParam("name") String name, @RequestParam("email") String email, Model model) {   
//		//http://localhost:8081/study/member/join?name=피피&id=pipi&pw=1234&email="pipi@apeach.com"
//		Member member = new Member();
//		
//		member.setName(name);
//		member.setId(id);
//		member.setPw(pw);
//		member.setEmail(email);
//		
//		model.addAttribute("member",member);
//		
//		return "member/join";
//
//	}
	
	
//	ver 3.
	@RequestMapping("/join")
	public String join(Member member) {   
		//http://localhost:8081/study/member/join?name=피피&id=pipi&pw=1234&email="pipi@apeach.com"
		
		return "member/join";

	}
	
}
