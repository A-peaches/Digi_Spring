package kr.soft.study.board.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.soft.study.board.db.BoardDAO;
import kr.soft.study.board.db.BoardDTO;
import kr.soft.study.command.Command;

public class BoardDetailAction implements Command {

	@Override
	public void execute(Model model) {
        Map<String, Object> map = model.asMap();
        HttpServletRequest request = (HttpServletRequest) map.get("request");

        BoardDAO boardDao = new BoardDAO();
        BoardDTO boardDto = new BoardDTO();

    	int num=Integer.parseInt(request.getParameter("num"));
    	boardDao.setReadCountUpdate(num);
    	boardDto = boardDao.getDetail(num);
    	
    	//�����Ͱ� ������
	   	if(boardDto == null) {
	   		System.out.println("�Խñ� ���������� �ҷ����� ����!");
	   	}
	   	
	   	System.out.println("�Խñ� ���������� �ҷ����� ����!");
	   	
	   	model.addAttribute("boardDto",boardDto);
	}

}
