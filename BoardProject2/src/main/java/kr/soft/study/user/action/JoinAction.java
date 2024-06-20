package kr.soft.study.user.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.soft.study.command.Command;
import kr.soft.study.user.db.UserDAO;
import kr.soft.study.user.db.UserDTO;

public class JoinAction implements Command {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		UserDAO userDao = new UserDAO();
		UserDTO userDto = new UserDTO();
		boolean result = false;
		
		
		userDto.setUser_id(request.getParameter("user_id"));
		userDto.setUser_pw(request.getParameter("user_pw"));
		userDto.setUser_email(request.getParameter("user_email"));
		userDto.setUser_name(request.getParameter("user_name"));
		
		String birth = request.getParameter("year")+"년 "+request.getParameter("month")+"월 "+
					   request.getParameter("day")+"일 ";
		System.out.println(birth);
		userDto.setBirth(birth);
		userDto.setHobby(request.getParameter("hobby"));
		userDto.setInfo(request.getParameter("info"));
		
		result = userDao.addMember(userDto);
		
		if(result == false) {
			System.out.println("회원가입 실패!");
		}
		System.out.println("회원가입 성공!");
	}

}
