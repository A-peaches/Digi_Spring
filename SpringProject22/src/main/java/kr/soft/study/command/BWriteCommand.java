package kr.soft.study.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.soft.study.controller.Constant;
import kr.soft.study.dao.IDao;



@Service
public class BWriteCommand implements BCommand{

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bTitle");
		
		System.out.println(bName);
		IDao dao = Constant.dao;
		int maxCount = dao.maxCount(); 
		dao.write(maxCount, bName, bTitle, bContent);
	}

}
