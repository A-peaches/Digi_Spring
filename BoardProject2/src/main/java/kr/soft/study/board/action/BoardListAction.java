package kr.soft.study.board.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.soft.study.board.db.BoardDAO;
import kr.soft.study.command.Command;


public class BoardListAction implements Command {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		BoardDAO boardDao = new BoardDAO();
		List boardlist=new ArrayList();
		
		int page=1;
		int limit=10;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		int listcount=boardDao.getListCount(); 
		boardlist = boardDao.getBoardList(page,limit); 
		
		int maxpage=(int)((double)listcount/limit+0.95); //한페이지당 10개가최대.
   		int startpage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
   		int endpage = maxpage;
   		
   		if (endpage>startpage+10-1) endpage=startpage+10-1;
   		
   		model.addAttribute("page", page);		
   		model.addAttribute("maxpage", maxpage);
   		model.addAttribute("startpage", startpage); 
   		model.addAttribute("endpage", endpage);   
   		model.addAttribute("listcount",listcount); 
   		model.addAttribute("boardlist", boardlist);
	}

}
