package kr.soft.study.basket.action;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import kr.soft.study.basket.db.BasketDAO;
import kr.soft.study.basket.db.BasketDTO;
import kr.soft.study.command.Command;

public class BasketAddAction implements Command {

	@Override
	public void execute(Model model) {
		
		BasketDTO basketDto = new BasketDTO();
		BasketDAO basketDao = new BasketDAO();
		
		Map<String, Object> map = model.asMap();
		HttpSession session = (HttpSession)map.get("session");
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String user_id = (String) session.getAttribute("user_id");
		ArrayList<BasketDTO> basketList = new ArrayList<BasketDTO>();
		ArrayList<BasketDTO> existBasket = new ArrayList<BasketDTO>();
		existBasket = basketDao.getBasket(user_id);
		
		int ameCnt = Integer.parseInt(request.getParameter("AmeCnt"));
		int doubleCnt = Integer.parseInt(request.getParameter("DoubleCnt"));
		int otmealCnt = Integer.parseInt(request.getParameter("OtmealCnt"));
		
		boolean exists = false;
		 if (existBasket != null) {
		        for (BasketDTO sb : existBasket) {
		            if ((sb.getFormat().equals("Ame") && ameCnt > 0) ||
		                (sb.getFormat().equals("Double") && doubleCnt > 0) ||
		                (sb.getFormat().equals("Otmeal") && otmealCnt > 0)) {
		                exists = true;
		                break;
		            }
		        }
		    }

			
		 if(exists) {
				model.addAttribute("message","이미 장바구니에 있습니다! 장바구니에서 수량을 변경해주세요!");
				model.addAttribute("url","./basketView");
				
				System.out.println("이미 있는 상품임!!");
				return; // 추가 처리를 중지
			}

		basketList = basketDao.basketInsert(user_id, ameCnt, doubleCnt, otmealCnt);
		
		model.addAttribute("basketList", basketList);
	}

}
