package kr.soft.study.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.soft.study.controller.Constant;
import kr.soft.study.dao.IDao;

public class BDeleteCommand implements BCommand{

	@Override
	public void execute(Model model) {
		
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bId = request.getParameter("bId");
		IDao dao = Constant.dao;
		dao.delete(bId);
		
	}

}
