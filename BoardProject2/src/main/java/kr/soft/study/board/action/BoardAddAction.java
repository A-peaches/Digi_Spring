package kr.soft.study.board.action;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletContext;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.soft.study.board.db.BoardDAO;
import kr.soft.study.board.db.BoardDTO;
import kr.soft.study.command.Command;

public class BoardAddAction implements Command {

    @Override
    public void execute(Model model) {
        Map<String, Object> map = model.asMap();
        HttpServletRequest request = (HttpServletRequest) map.get("request");

        BoardDAO boardDao = new BoardDAO();
        BoardDTO boardDto = new BoardDTO();

        String saveFolder = "boardupload";

        // ServletContext가 null인지 확인
        ServletContext context = request.getSession().getServletContext();
        System.out.println(context);
        if (context == null) {
            System.out.println("ServletContext is null");
            return;
        }

        String realFolder =  "/library/upload/";
        System.out.println("Real folder: " + realFolder);

        boolean result = false;

        try {
            if (request instanceof MultipartHttpServletRequest) {
                MultipartHttpServletRequest multi = (MultipartHttpServletRequest) request;
                MultipartFile file = multi.getFile("BOARD_FILE");

                if (file != null && !file.isEmpty()) {
                    String fileName = file.getOriginalFilename();
                    String filePath = realFolder + File.separator + fileName;
                    File dest = new File(filePath);
                    file.transferTo(dest);
                    boardDto.setBOARD_FILE(fileName);
                }
            } else {
                System.out.println("Request is not a MultipartHttpServletRequest");
            }

            boardDto.setBOARD_NAME(request.getParameter("BOARD_NAME"));
            boardDto.setBOARD_PASS(request.getParameter("BOARD_PASS"));
            boardDto.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
            boardDto.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));

            System.out.println("BOARD_NAME: " + boardDto.getBOARD_NAME());
            System.out.println("BOARD_FILE: " + boardDto.getBOARD_FILE());
            result = boardDao.boardInsert(boardDto);

            if (!result) {
                System.out.println("게시글 등록에 실패하였습니다.");
            } else {
                System.out.println("게시글 등록에 성공하였습니다.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
