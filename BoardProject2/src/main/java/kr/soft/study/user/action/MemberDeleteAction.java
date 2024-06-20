package kr.soft.study.user.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.soft.study.command.Command;
import kr.soft.study.user.db.UserDAO;
import kr.soft.study.user.db.UserDTO;

public class MemberDeleteAction implements Command {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		UserDAO userDao = new UserDAO();
		UserDTO userDto = new UserDTO();
		String user_id = request.getParameter("user_id");
		
		int result = 0;
		result = userDao.memberDelete(user_id);
		
		if(result > 0 ) {
	   		System.out.println("회원 삭제 성공!");
		} else {
			System.out.println("회원 삭제 실패!");
		}
		
	}

}
