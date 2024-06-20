package kr.soft.study;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.soft.study.dao.CDao;
import kr.soft.study.service.Service;

public class AddCartService implements Service {

	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int ameCnt = Integer.parseInt(request.getParameter("AmeCnt"));
		int doubleCnt = Integer.parseInt(request.getParameter("DoubleCnt"));
		int otmealCnt = Integer.parseInt(request.getParameter("OtmealCnt"));
		
		System.out.println(ameCnt);
		System.out.println(doubleCnt);
		System.out.println(otmealCnt);
		
		String[] names = {"AmericanCookie","DoubleChocoCookie","OtmealCookie"};
		int[] prices = { 3000, 2800, 2600 };
		int[] count = { ameCnt, doubleCnt, otmealCnt };
		CDao Cdao = new CDao();
		
		for(int i=0; i<names.length; i++) {
			Cdao.addCart(names[i], prices[i], count[i]);
		}
		
	}

}
