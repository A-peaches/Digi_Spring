package kr.soft.study.board.db;

import java.sql.*;

import javax.naming.*;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import kr.soft.study.Constant;

import java.util.*;

public class BoardDAO {

	JdbcTemplate template;


	public BoardDAO() {
		this.template = Constant.template;;
	}

	public int getListCount() {
		String sql = "select count(*) from board";
		int cnt = 0;

		try {
			cnt = template.queryForObject(sql, Integer.class);
			
			
		} catch (Exception ex) {
			System.out.println("getListCount Error: " + ex);
			
		} 
		return cnt;
	}

	
	public List getBoardList(int page, int limit) {
		String sql = "select * from "
				+ "(select row_number() over() rnum,BOARD_NUM,BOARD_NAME,BOARD_SUBJECT,"
				+ "BOARD_CONTENT,BOARD_FILE,BOARD_RE_REF,BOARD_RE_LEV,"
				+ "BOARD_RE_SEQ,BOARD_READCOUNT,BOARD_DATE from "
				+ "(select * from board order by BOARD_RE_REF desc,BOARD_RE_SEQ asc) AS s)AS u "
				+ "where rnum>=? and rnum<=?"; 

		List list = new ArrayList();

		int startrow = (page - 1) * 10 + 1; 
		int endrow = startrow + limit - 1; 

		try {
			
			list = template.query(sql,new Object[] {startrow, endrow}, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
			return list;
			
		} catch (Exception ex) {
			System.out.println("getBoardList Error : " + ex);
		} 
		
		
		return list;
	}

	public boolean boardInsert(BoardDTO board) {
		int num = 0;
		String sql = "";

		int result = 0;

		try {
			sql = "select max(board_num) from board";
			Integer maxNum = template.queryForObject(sql, Integer.class);
	
			if (maxNum > 0) {
				num = maxNum + 1;
			} else {
				num = 1;
			}

			sql = "insert into board(BOARD_NUM,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,"
					+ "BOARD_CONTENT,BOARD_FILE,BOARD_RE_REF,BOARD_RE_LEV,"
					+ "BOARD_RE_SEQ,BOARD_READCOUNT,BOARD_DATE) values " + "(?,?,?,?,?,?,?,?,?,?,now())";
			
			result = template.update(sql, new Object[] { num, board.getBOARD_NAME(), board.getBOARD_PASS(), board.getBOARD_SUBJECT(), 
                    board.getBOARD_CONTENT(), board.getBOARD_FILE(), num, 0, 0, 0 });
			
			return result > 0;
		} catch (Exception e) {
			System.out.println("boardInsert Error : " + e);
			return false;
		}


	}

	public void setReadCountUpdate(int num) {
		String sql = "update board set BOARD_READCOUNT = BOARD_READCOUNT+1 where BOARD_NUM = ?";
		try {
			template.update(sql, num);
		} catch (Exception ex) {
			System.out.println("setReadCountUpdate Error : " + ex);
		} 
	}

	public BoardDTO getDetail(int num) {
		String sql = "select * from board where BOARD_NUM = ?";
		try {
			return template.queryForObject(sql, new Object[] { num }, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
			

		} catch (Exception e) {
			System.out.println("getDetail Error :" + e);
			return null;
		} 
	}

	public boolean boardDelete(int num) {
		String sql = "delete from board where BOARD_NUM = ?";
		int result = 0;
		
		try {
			result = template.update(sql, num);
	
		} catch (Exception e) {
			System.out.println("boardDelete Error : " + e);
		} 
		
		return result > 0;
	}

	public boolean isBoardWriter(int num, String pass) {
		String sql = "select BOARD_PASS from board where BOARD_NUM = ?";

		try {
			String dbPass = template.queryForObject(sql, new Object[] {num}, String.class);

			if (pass.equals(dbPass)) {
				return true;
			}
			
		} catch (Exception ex) {
			System.out.println("isBoardWriter Error : " + ex);
		} 
		
		return false;
	}

	public boolean boardModify(BoardDTO boardData) {
		String sql = "update board set BOARD_NAME=?,BOARD_SUBJECT=?,BOARD_CONTENT=? where BOARD_NUM=?";
		int result = 0;

		try {
			result = template.update(sql,new Object[] {boardData.getBOARD_NAME(), boardData.getBOARD_SUBJECT(),
					boardData.getBOARD_CONTENT(),boardData.getBOARD_NUM() });

		} catch (Exception ex) {
			System.out.println("boardModify Error : " + ex);
		}
		
		return result > 0;
	}

	public int boardReply(BoardDTO board) {
		int num = 0;
		String boardMaxSql = "SELECT MAX(board_num) FROM board";
		String updateSql = "UPDATE board SET BOARD_RE_SEQ = BOARD_RE_SEQ + 1 WHERE BOARD_RE_REF = ? AND BOARD_RE_SEQ > ?";
		String insertSql = "INSERT INTO board (BOARD_NUM, BOARD_NAME, BOARD_PASS, BOARD_SUBJECT, BOARD_CONTENT, BOARD_FILE, BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ, BOARD_READCOUNT, BOARD_DATE) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";

		try {
			Integer maxNum = template.queryForObject(boardMaxSql, Integer.class);
			num = (maxNum != null) ? maxNum + 1 : 1;

			// Update the BOARD_RE_SEQ
			template.update(updateSql, board.getBOARD_RE_REF(), board.getBOARD_RE_SEQ());

			// Prepare the values for the new reply
			int reSeq = board.getBOARD_RE_SEQ() + 1;
			int reLev = board.getBOARD_RE_LEV() + 1;

			// Insert the new reply
			template.update(insertSql, new Object[] { num, board.getBOARD_NAME(), board.getBOARD_PASS(),
					board.getBOARD_SUBJECT(), board.getBOARD_CONTENT(), "", board.getBOARD_RE_REF(), reLev, reSeq, 0 });

		} catch (Exception e) {
			System.out.println("boardReply Error! : " + e);
		}

		return num;

	}
}
