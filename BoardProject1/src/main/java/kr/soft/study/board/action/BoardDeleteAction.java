package kr.soft.study.board.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.soft.study.board.db.BoardDAO;
import kr.soft.study.board.db.BoardDTO;
import kr.soft.study.command.Command;

public class BoardDeleteAction implements Command {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		BoardDAO boardDao = new BoardDAO();
		BoardDTO boardDto = new BoardDTO();

		boolean result = false;
		boolean usercheck = false;
		int num = Integer.parseInt(request.getParameter("num"));

		// 비밀번호 체크
		usercheck = boardDao.isBoardWriter(num, request.getParameter("BOARD_PASS"));

		if (usercheck == false) {
	        model.addAttribute("message", "PW가 일치하지 않습니다!");
	        model.addAttribute("url", "boardList");

			return;
		}

		// 데이터 삭제 정상처리 검증
		result = boardDao.boardDelete(num);
		if (result == false) {
			System.out.println("게시글 삭제 실패!");
		}

		System.out.println("게시글 삭제 성공!");

	}

}
