package kr.soft.study;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.soft.study.command.Command;
import kr.soft.study.user.action.JoinAction;
import kr.soft.study.user.action.LoginAction;
import kr.soft.study.user.action.MemberDeleteAction;
import kr.soft.study.user.action.MemberListAction;
import kr.soft.study.user.action.MyPageAction;


@Controller
public class UserController {
	
	Command command = null;
	
	// login View
	@RequestMapping("/login")
	public String login() {
		System.out.println("/login");
		return "user/loginForm";
	}
	
	// join View
	@RequestMapping("/joinView")
	public String joinView() {
		System.out.println("/joinView");
		return "user/joinForm";
	}
	
	// main View
	@RequestMapping("/main")
	public String main() {
		System.out.println("/main");
		return "user/main";
	}
	
	// logout
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		System.out.println("/logout");
		session.invalidate();
		
		return "redirect:login";
	}
	
	// join Action
	@RequestMapping("/joinAction")
	public String joinAction(HttpServletRequest request, Model model) {
		System.out.println("/joinAction");
		model.addAttribute("request", request);
		command = new JoinAction();
		command.execute(model);
		
		return "redirect:login";
	}
	
	//loginAction
	@RequestMapping("/loginAction")
	public String loginAction(HttpServletRequest request,  Model model) {
		System.out.println("/loginAction");
		model.addAttribute("request", request);
		command = new LoginAction();
		command.execute(model);
		
	    Map<String, Object> map = model.asMap();
	     
        // 메시지가 있는 경우, 로그인 실패로 간주하고 메시지와 함께 로그인 폼으로 리다이렉트
        if (map.containsKey("message")) {
            model.addAttribute("message", map.get("message"));
            model.addAttribute("url", map.get("url"));
            return "message";
        }
        
		return "redirect:main";
	}
	
	// myPage
	@RequestMapping("/myPage")
	public String myPage(Model model, HttpSession session) {
		System.out.println("/myPage");
		model.addAttribute("session", session);
		command = new MyPageAction();
		command.execute(model);
		
		return "user/myPage";
	}
	
	
	// memberList
		@RequestMapping("/memberList")
		public String memberList(Model model, HttpSession session) {
			System.out.println("/memberList");
			model.addAttribute("session", session);
			command = new MemberListAction();
			command.execute(model);
			
			return "user/memberList";
		}
		
		// memberDelete
		@RequestMapping("/memberDelete")
		public String memberDelete(Model model, HttpServletRequest request) {
			System.out.println("/memberDelete");
			model.addAttribute("request", request);
			command = new MemberDeleteAction();
			command.execute(model);
			
			return "redirect:memberList";
		}
		
	
}
