package kr.soft.study.basket.action;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import kr.soft.study.basket.db.BasketDAO;
import kr.soft.study.basket.db.BasketDTO;
import kr.soft.study.command.Command;

public class BasketChangeAction implements Command {

	@Override
	public void execute(Model model) {
		BasketDTO basketDto = new BasketDTO();
		BasketDAO basketDao = new BasketDAO();
		
		Map<String, Object> map = model.asMap();
		HttpSession session = (HttpSession)map.get("session");
		HttpServletRequest request = (HttpServletRequest)map.get("request");

		String user_id = (String) session.getAttribute("user_id");
		ArrayList<BasketDTO> basketList = new ArrayList<BasketDTO>();
		
		int ameCnt = 0;
		int doubleCnt = 0;
		int otmealCnt = 0;
		
		String ameCntStr = request.getParameter("AmeCnt");
		if (ameCntStr != null && !ameCntStr.isEmpty()) {
		    ameCnt = Integer.parseInt(ameCntStr);
		}

		String doubleCntStr = request.getParameter("DoubleCnt");
		if (doubleCntStr != null && !doubleCntStr.isEmpty()) {
		    doubleCnt = Integer.parseInt(doubleCntStr);
		}

		String otmealCntStr = request.getParameter("OtmealCnt");
		if (otmealCntStr != null && !otmealCntStr.isEmpty()) {
			otmealCnt = Integer.parseInt(otmealCntStr);
		}
		
		basketDao.removeAll(user_id);
		basketList = basketDao.basketInsert(user_id, ameCnt, doubleCnt, otmealCnt);
		
		System.out.println("장바구니 업데이트 성공!");
	}

}
