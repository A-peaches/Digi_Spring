package kr.soft.study.user.action;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import kr.soft.study.command.Command;
import kr.soft.study.user.db.UserDAO;
import kr.soft.study.user.db.UserDTO;

public class MemberListAction implements Command {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpSession session = (HttpSession) map.get("session");
		UserDAO userDao = new UserDAO();
		UserDTO userDto = new UserDTO();

		ArrayList<UserDTO> memberList = new ArrayList<UserDTO>();
		String user_id = (String) session.getAttribute("user_id");

		memberList = userDao.getMemberList();

		model.addAttribute("memberList", memberList);


	}

}
