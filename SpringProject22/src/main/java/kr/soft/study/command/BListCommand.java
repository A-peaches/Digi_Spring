package kr.soft.study.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import kr.soft.study.controller.Constant;
import kr.soft.study.dao.IDao;
import kr.soft.study.dto.BDto;

public class BListCommand implements BCommand{

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		IDao dao = Constant.dao;
		ArrayList<BDto> dtos = dao.list();
		model.addAttribute("list",dtos);
	}

}
