package kr.soft.study;

import org.springframework.ui.Model;

import kr.soft.study.dao.CDao;
import kr.soft.study.service.Service;

public class deleteCartService implements Service {

	@Override
	public void execute(Model model) {
		
		CDao Cdao = new CDao();
		Cdao.deleteCart();
		
	}

}
