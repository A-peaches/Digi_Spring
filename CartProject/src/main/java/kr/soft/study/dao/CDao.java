package kr.soft.study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import kr.soft.study.dto.Cookie;
import kr.soft.study.service.Constant;

public class CDao {
	JdbcTemplate template;

	public CDao() {
		this.template = Constant.template;
	}

	public void addCart(final String cookieName, final int cookiePrice, final int cookieCnt) {

		this.template.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

				String sql = "INSERT INTO cart (cookie_name, cookie_price, cookie_cnt) VALUES (?, ?, ?)";
				PreparedStatement pstmt = con.prepareStatement(sql);

				pstmt.setString(1, cookieName);
				pstmt.setInt(2, cookiePrice);
				pstmt.setInt(3, cookieCnt);

				return pstmt;
			}
		});
	}

	public ArrayList<Cookie> list() {
		String query = "select * from cart";
		return (ArrayList<Cookie>) template.query(query, new BeanPropertyRowMapper<Cookie>(Cookie.class));

	}

	public void deleteCart() {
		String query = "delete from cart";

		this.template.update(query);

	}

}
