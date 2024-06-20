package kr.soft.study.user.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import kr.soft.study.command.Command;
import kr.soft.study.user.db.UserDAO;
import kr.soft.study.user.db.UserDTO;

public class LoginAction implements Command {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		UserDTO userDto = new UserDTO();
		UserDAO userDao = new UserDAO();

		boolean result = false;
		boolean isAdmin = false;
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");		

		result = userDao.loginCheck(user_id,user_pw);
		isAdmin = userDao.adminCheck(user_id);
		
		if(!result) {
            model.addAttribute("message", "ID 또는 PW가 일치하지 않습니다!");
            model.addAttribute("url", "login");
            return;
		}
		
		System.out.println("로그인 성공!");
		
		HttpSession session = request.getSession();
		session.setAttribute("user_id",user_id);
		session.setAttribute("user_pw",user_pw);
		session.setAttribute("user_pw",isAdmin);
	}

}
