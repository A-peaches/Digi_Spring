package kr.soft.study.user.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import kr.soft.study.command.Command;
import kr.soft.study.user.db.UserDAO;
import kr.soft.study.user.db.UserDTO;

public class MyPageAction implements Command {

	@Override
	public void execute(Model model) {
        Map<String, Object> map = model.asMap();
        HttpServletRequest request = (HttpServletRequest) map.get("request");
        HttpSession session = (HttpSession) map.get("session");
        UserDAO userDao = new UserDAO();
        UserDTO userDto = new UserDTO();
        
        
		String user_id = (String) session.getAttribute("user_id");
		
		userDto = userDao.getUserInfo(user_id);
		
		if(userDto == null) {
			System.out.println("데이터 불러오기 실패!");
		}
		
		model.addAttribute("userDto", userDto);
		session.setAttribute("isAdmin", userDto.getIsadmin());
		
		System.out.println("관리자여부 : " +userDto.getIsadmin());
	}

}
