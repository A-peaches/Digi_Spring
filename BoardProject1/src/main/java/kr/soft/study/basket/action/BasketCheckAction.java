package kr.soft.study.basket.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import kr.soft.study.basket.db.BasketDAO;
import kr.soft.study.basket.db.BasketDTO;
import kr.soft.study.command.Command;

public class BasketCheckAction implements Command {

	@Override
	public void execute(Model model) {
		BasketDTO basketDto = new BasketDTO();
		BasketDAO basketDao = new BasketDAO();
		
		Map<String, Object> map = model.asMap();
		HttpSession session = (HttpSession)map.get("session");
		

		String user_id = (String) session.getAttribute("user_id");
		
		basketDao.removeAll(user_id);
		
		System.out.println("���� ����!");
		
		model.addAttribute("message","������ �Ϸ�Ǿ����ϴ�!");
		model.addAttribute("url","./basketView");

		
	}

}
