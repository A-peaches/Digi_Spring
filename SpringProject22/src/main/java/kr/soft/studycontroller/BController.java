package kr.soft.studycontroller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import kr.soft.study.command.BCommand;

@Controller
public class BController {
	
	BCommand command = null;
	
	private JdbcTemplate template;
}
