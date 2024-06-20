package kr.soft.study.board.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.soft.study.board.db.BoardDAO;
import kr.soft.study.board.db.BoardDTO;
import kr.soft.study.command.Command;

public class BoardReplyAction implements Command {

	@Override
	public void execute(Model model) {
        Map<String, Object> map = model.asMap();
        HttpServletRequest request = (HttpServletRequest) map.get("request");

        BoardDAO boardDao = new BoardDAO();
        BoardDTO boardDto = new BoardDTO();
        
        int result = 0;
		
        boardDto.setBOARD_NUM(Integer.parseInt(request.getParameter("BOARD_NUM")));
        boardDto.setBOARD_NAME(request.getParameter("BOARD_NAME"));
        boardDto.setBOARD_PASS(request.getParameter("BOARD_PASS"));
        boardDto.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
        boardDto.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));
        boardDto.setBOARD_RE_REF(Integer.parseInt(request.getParameter("BOARD_RE_REF")));
        boardDto.setBOARD_RE_LEV(Integer.parseInt(request.getParameter("BOARD_RE_LEV")));
        boardDto.setBOARD_RE_SEQ(Integer.parseInt(request.getParameter("BOARD_RE_SEQ")));
   	

   		result = boardDao.boardReply(boardDto);
   		if(result == 0) {
   			System.out.println("답글 등록 실패!");
   		}
		 
   		System.out.println("답글 등록 성공!");
   		
	}

}
