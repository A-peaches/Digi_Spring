package kr.soft.study.basket.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import kr.soft.study.basket.db.BasketDAO;
import kr.soft.study.basket.db.BasketDTO;
import kr.soft.study.command.Command;

public class BasketRemoveAction implements Command {

	@Override
	public void execute(Model model) {
		
		BasketDTO basketDto = new BasketDTO();
		BasketDAO basketDao = new BasketDAO();
		
		Map<String, Object> map = model.asMap();
		HttpSession session = (HttpSession)map.get("session");
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		int result = 0;
		String cookie_name = request.getParameter("cookie_name");
		String user_id = (String) session.getAttribute("user_id");
		
		if (cookie_name.equals("Ame")) {
			cookie_name = "American Cookie";
		} else if (cookie_name.equals("Double")) {
			cookie_name = "Double Choco Cookie";
		} else if (cookie_name.equals("Otmeal")) {
			cookie_name = "Otmeal Cookie";
		}

		result = basketDao.basketRemove(user_id, cookie_name);
		
		if(result > 0 ) {
	   		System.out.println("장바구니 삭제 성공!");
		} else {	
			System.out.println("장바구니 삭제 실패!");
		}
	}
	
}
