package kr.soft.study;

import java.util.ArrayList;

import org.springframework.ui.Model;

import kr.soft.study.dao.CDao;
import kr.soft.study.dto.Cookie;
import kr.soft.study.service.Service;

public class getCartService implements Service {

	@Override
	public void execute(Model model) {
		CDao Cdao = new CDao();
		ArrayList<Cookie> dtos = Cdao.list();
		
		for(Cookie li : dtos) {
			System.out.println(li.getCookie_cnt());
		}
		model.addAttribute("list",dtos);
	}

}
