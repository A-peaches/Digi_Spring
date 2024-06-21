package kr.soft.study;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.soft.study.board.action.BoardAddAction;
import kr.soft.study.board.action.BoardDeleteAction;
import kr.soft.study.board.action.BoardDetailAction;
import kr.soft.study.board.action.BoardListAction;
import kr.soft.study.board.action.BoardModifyAction;
import kr.soft.study.board.action.BoardModifyViewAction;
import kr.soft.study.board.action.BoardReplyAction;
import kr.soft.study.board.action.BoardReplyViewAction;
import kr.soft.study.command.Command;


@Controller
public class BoardController {
	
	Command command = null;
	
	@RequestMapping("/boardList")
	public String boardList(HttpServletRequest request, Model model) {
		System.out.println("/boardList");
		
		command = new BoardListAction();
		model.addAttribute("request", request);
		command.execute(model);
		
		return "board/boardList";
	}
	
	@RequestMapping("/boardWrite")
	public String boardWrite() {
		System.out.println("/boardWrite");
		return "board/boardWrite";
	}
	
	@RequestMapping("/boardAdd")
	public String boardAdd(HttpServletRequest request, Model model) {
		System.out.println("/boardAdd");
		model.addAttribute("request", request);
		command = new BoardAddAction();
		command.execute(model);
		return "redirect:boardList";
	}
	
	@RequestMapping("/boardDetail")
	public String boardDetail(HttpServletRequest request, Model model) {
		System.out.println("/boardDetail");
		model.addAttribute("request", request);
		
		command = new BoardDetailAction();
		command.execute(model);
		
		return "board/boardDetail";
	}
	
	@RequestMapping("/boardDeleteView")
	public String boardDeleteView(HttpServletRequest request, Model model) {
		System.out.println("/boardDeleteView");
		int num = Integer.parseInt(request.getParameter("num"));
		model.addAttribute("num", num);
		return "board/boardDelete";
	}
	
	
	@RequestMapping("/boardDelete")
	public String boardDelete(HttpServletRequest request, Model model) {
		System.out.println("/boardDelete");
		model.addAttribute("request", request);
		
		command = new BoardDeleteAction();
		command.execute(model);
		
	    Map<String, Object> map = model.asMap();
	    
        // 메시지가 있는 경우, 로그인 실패로 간주하고 메시지와 함께 로그인 폼으로 리다이렉트
        if (map.containsKey("message")) {
            model.addAttribute("message", map.get("message"));
            model.addAttribute("url", map.get("url"));
            return "message";
        }
        
        
		return "redirect:boardList";
	}
	
	@RequestMapping("/boardModifyView")
	public String boardModifyView(HttpServletRequest request, Model model) {
		System.out.println("/boardModifyView");
		model.addAttribute("request", request);
		
		command = new BoardModifyViewAction();
		command.execute(model);

        
		return "board/boardModify";
	}
	
	@RequestMapping("/boardModify")
	public String boardModify(HttpServletRequest request, Model model) {
		System.out.println("/boardModify");
		model.addAttribute("request", request);
		
		command = new BoardModifyAction();
		command.execute(model);

	    Map<String, Object> map = model.asMap();
	    
	    
        // 메시지가 있는 경우, 로그인 실패로 간주하고 메시지와 함께 로그인 폼으로 리다이렉트
        if (map.containsKey("message")) {
            model.addAttribute("message", map.get("message"));
            model.addAttribute("url", map.get("url"));
            return "message";
        }
        
        
	    request = (HttpServletRequest) map.get("request");
	    int num = Integer.parseInt(request.getParameter("BOARD_NUM"));
	    
		return "redirect:boardDetail?num="+num;
	}
	
	@RequestMapping("/boardReplyView")
	public String boardReplyView(HttpServletRequest request, Model model) {
		System.out.println("/boardReplyView");
		model.addAttribute("request", request);
		
		command = new BoardReplyViewAction();
		command.execute(model);

        
		return "board/boardReply";
	}
	
	@RequestMapping("/boardReply")
	public String boardReply(HttpServletRequest request, Model model) {
		System.out.println("/boardReply");
		model.addAttribute("request", request);
		
		command = new BoardReplyAction();
		command.execute(model);

        
		return "redirect:boardList";
	}
	
	private String context = "C:\\library\\upload\\";

	@RequestMapping("/download")
	public ResponseEntity<InputStreamResource> fileDownload(@RequestParam String fileName) throws IOException {
		String filePath = context + fileName;
		System.out.println("File path: " + filePath);
		File file = new File(filePath);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.contentLength(file.length()).body(resource);
	}
}
