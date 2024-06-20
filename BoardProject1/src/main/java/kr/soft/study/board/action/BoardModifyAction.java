package kr.soft.study.board.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.soft.study.board.db.BoardDAO;
import kr.soft.study.board.db.BoardDTO;
import kr.soft.study.command.Command;

public class BoardModifyAction implements Command {

	@Override
	public void execute(Model model) {
        Map<String, Object> map = model.asMap();
        HttpServletRequest request = (HttpServletRequest) map.get("request");

        BoardDAO boardDao = new BoardDAO();
        BoardDTO boardDto = new BoardDTO();
        
        boolean result = false;
        
        int num = Integer.parseInt(request.getParameter("BOARD_NUM"));

		
		// 비밀번호 체크
		boolean usercheck = boardDao.isBoardWriter(num, request.getParameter("BOARD_PASS"));

		if (usercheck == false) {
	        model.addAttribute("message", "PW가 일치하지 않습니다!");
	        model.addAttribute("url", "boardDetail?num="+num);

			return;
		}

		
		try{
			boardDto.setBOARD_NUM(num);
			boardDto.setBOARD_NAME(request.getParameter("BOARD_NAME"));
			boardDto.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
			boardDto.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));
			
			result = boardDao.boardModify(boardDto);
			
			if(result == false) {
				System.out.println("게시글 수정 실패!");
			}
			
			System.out.println("게시글 수정 성공!");
		
			}catch(Exception ex){
				ex.printStackTrace();	
			}
	}
}