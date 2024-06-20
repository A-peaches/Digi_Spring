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

		// ��й�ȣ üũ
		usercheck = boardDao.isBoardWriter(num, request.getParameter("BOARD_PASS"));

		if (usercheck == false) {
	        model.addAttribute("message", "PW�� ��ġ���� �ʽ��ϴ�!");
	        model.addAttribute("url", "boardList");

			return;
		}

		// ������ ���� ����ó�� ����
		result = boardDao.boardDelete(num);
		if (result == false) {
			System.out.println("�Խñ� ���� ����!");
		}

		System.out.println("�Խñ� ���� ����!");

	}

}
