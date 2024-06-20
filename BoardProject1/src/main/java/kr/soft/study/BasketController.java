package kr.soft.study;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.soft.study.basket.action.BasketAddAction;
import kr.soft.study.basket.action.BasketChangeAction;
import kr.soft.study.basket.action.BasketCheckAction;
import kr.soft.study.basket.action.BasketRemoveAction;
import kr.soft.study.basket.action.BasketViewAction;
import kr.soft.study.board.action.BoardAddAction;
import kr.soft.study.board.action.BoardDeleteAction;
import kr.soft.study.board.action.BoardDetailAction;
import kr.soft.study.board.action.BoardListAction;
import kr.soft.study.board.action.BoardModifyAction;
import kr.soft.study.board.action.BoardModifyViewAction;
import kr.soft.study.board.action.BoardReplyAction;
import kr.soft.study.board.action.BoardReplyViewAction;
import kr.soft.study.command.Command;


@Controller
public class BasketController {
	
	Command command = null;
	
	@RequestMapping("/cookieList")
	public String boardList() {
		System.out.println("/cookieList");
		
		return "basket/cookieList";
	}

	@RequestMapping("/basketView")
	public String basketView(HttpSession session, Model model) {
		System.out.println("/basketView");
		model.addAttribute("session",session);
		command = new BasketViewAction();
		command.execute(model);
		return "basket/cookieCart";
	}
	
	@RequestMapping("/basketAdd")
	public String basketView(HttpServletRequest request,HttpSession session, Model model) {
		System.out.println("/basketAdd");
		model.addAttribute("request",request);
		model.addAttribute("session",session);
		
		command = new BasketAddAction();
		command.execute(model);
		
	    Map<String, Object> map = model.asMap();
	    
        if (map.containsKey("message")) {
            model.addAttribute("message", map.get("message"));
            model.addAttribute("url", map.get("url"));
            return "message";
        }
        
		return "redirect:basketView";
	}
	

	@RequestMapping("/basketRemove")
	public String basketRemove(HttpServletRequest request, HttpSession session,Model model) {
		System.out.println("/basketRemove");
		model.addAttribute("session",session);
		model.addAttribute("request",request);
		command = new BasketRemoveAction();
		command.execute(model);
        
		return "redirect:basketView";
	}
	
	@RequestMapping("/basketChange")
	public String basketChange(HttpServletRequest request, HttpSession session, Model model) {
		System.out.println("/basketChange");
		model.addAttribute("session",session);
		model.addAttribute("request",request);
		command = new BasketChangeAction();
		command.execute(model);
        
		return "redirect:basketView";
	}
	
	@RequestMapping("/basketCheck")
	public String basketChange(HttpSession session, Model model) {
		System.out.println("/basketChange");
		model.addAttribute("session",session);
		command = new BasketCheckAction();
		command.execute(model);
		
		 Map<String, Object> map = model.asMap();
		 
        if (map.containsKey("message")) {
            model.addAttribute("message", map.get("message"));
            model.addAttribute("url", map.get("url"));
            return "message";
        }
        
        return "message";
	}
	
}
