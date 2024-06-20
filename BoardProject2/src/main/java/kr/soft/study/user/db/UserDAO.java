package kr.soft.study.user.db;

import java.sql.*;

import javax.naming.*;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import kr.soft.study.Constant;

import java.util.*;

public class UserDAO {

	JdbcTemplate template;

	public UserDAO() {
		template = Constant.template;
	}

	public boolean addMember(final UserDTO joinData) {
		String sql = "insert into userInfo (user_id, user_name, user_pw, user_email, birth, hobby, info) values"
				+ "(?,?,?,?,?,?,?)";
		try {
			int result = template.update(sql, new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, joinData.getUser_id());
					ps.setString(2, joinData.getUser_name());
					ps.setString(3, joinData.getUser_pw());
					ps.setString(4, joinData.getUser_email());
					ps.setString(5, joinData.getBirth());
					ps.setString(6, joinData.getHobby());
					ps.setString(7, joinData.getInfo());
				}

			});
			return result > 0;
		} catch (Exception e) {
			System.out.println("addMember Error!: " + e);
			return false;
		}

	}

	public boolean loginCheck(String user_id, String user_pw) {
		String sql = "Select user_id from userInfo where user_id = ? AND user_pw = ?";

		try {
			String dbUserId = template.queryForObject(sql, new Object[] { user_id, user_pw }, new RowMapper<String>() {

				@Override
				public String mapRow(ResultSet rs, int rowNum) throws SQLException {
					return rs.getString("user_id");
				}
			});
			return dbUserId.equals(user_id);

		} catch (Exception e) {
			System.out.println("loginCheck Error!: " + e);
			return false;
		}
	}

	public UserDTO getUserInfo(String user_id) {
		String sql = "select * from userInfo where user_id = ?";
	      try {
	            return template.queryForObject(sql, new Object[]{user_id}, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
	        } catch (Exception e) {
	            System.out.println("getUserInfo Error!: " + e);
	            return null;
	        }
	}

	public boolean adminCheck(String user_id) throws SQLException {
		String sql = "select isadmin from userInfo where user_id = ?";
		boolean isAdmin = false;

		try {
		isAdmin = template.queryForObject(sql, new Object[] {user_id}, new RowMapper<Boolean>() {
			@Override
			public Boolean mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getBoolean("isadmin");
			}
		});
		} catch(Exception ex) {
			System.out.println("adminCheck Error! : "+ ex);
		}
		
		return isAdmin;
	}

	public ArrayList<UserDTO> getMemberList() {
		String sql = "select * from userInfo where isadmin = 0";
		return (ArrayList<UserDTO>) template.query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		
	}

	public int memberDelete(String user_id) {
		String sql = "delete from userInfo where user_id =?";
		int result = 0;

		try {
	        result = template.update(sql, user_id);
	        return result;

		} catch (Exception e) {
			System.out.println("MemberDelete Error! : " + e);
		} 
		
		return result;
	}

}
