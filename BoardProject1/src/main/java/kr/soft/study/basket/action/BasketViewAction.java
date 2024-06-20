package kr.soft.study.basket.action;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import kr.soft.study.basket.db.BasketDAO;
import kr.soft.study.basket.db.BasketDTO;
import kr.soft.study.command.Command;

public class BasketViewAction implements Command {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpSession session = (HttpSession)map.get("session");
		String user_id = (String) session.getAttribute("user_id");
		
		BasketDTO basketDto = new BasketDTO();
		BasketDAO basketDao = new BasketDAO();
		
		ArrayList<BasketDTO> basketList = new ArrayList<BasketDTO>();
		
		basketList = basketDao.getBasket(user_id);
		
		if(basketList == null) {
			model.addAttribute("basketList", null);
		} else {
			model.addAttribute("basketList", basketList);
		}
	}

}
