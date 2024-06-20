package kr.soft.study.basket.db;

import java.sql.*;

import javax.naming.*;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import kr.soft.study.Constant;

import java.util.*;

public class BasketDAO {

	JdbcTemplate template;

	public BasketDAO() {
		this.template = Constant.template;
	}

	public ArrayList<BasketDTO> basketInsert(String user_id, int ameCnt, int doubleCnt, int otmealCnt) {
		ArrayList<BasketDTO> basketList = new ArrayList<BasketDTO>();
		String sql = "INSERT INTO basket (user_id, cookie_name, cookie_img, cookie_qnt, cookie_price) VALUES (?, ?, ?, ?, ?)";

		String[] cookieNames = { "American Cookie", "Double Choco Cookie", "Otmeal Cookie" };
		int[] cookieCounts = { ameCnt, doubleCnt, otmealCnt };
		String[] cookieImages = { "resources/img/cookie1.png", "resources/img/cookie2.png",
				"resources/img/cookie3.png" };
		int[] cookiePrices = { 3000, 2800, 2600 };

		System.out.println("웅앵!");
		try {
			for (int i = 0; i < cookieCounts.length; i++) {
				if (cookieCounts[i] != 0) {
					BasketDTO cookies = new BasketDTO();
					cookies.setUser_id(user_id);
					cookies.setCookie_name(cookieNames[i]);
					cookies.setCookie_img(cookieImages[i]);
					cookies.setCookie_qnt(cookieCounts[i]);
					cookies.setCookie_price(cookiePrices[i]);

					basketList.add(cookies);

					int result = template.update(sql, cookies.getUser_id(), cookies.getCookie_name(),
							cookies.getCookie_img(), cookies.getCookie_qnt(), cookies.getCookie_price());
					if (result == 0) {
						return null;
					}
				}
			}
			return basketList;

		} catch (Exception e) {
			System.out.println("BasketInsert Error! : " + e);
			return null;
		}
	}

	public ArrayList<BasketDTO> getBasket(String user_id) {
		String sql = "select * from basket where user_id = ?";
		ArrayList<BasketDTO> list = new ArrayList<BasketDTO>();

		try {
			return (ArrayList<BasketDTO>) template.query(sql, new Object[] { user_id },
					new BeanPropertyRowMapper<BasketDTO>(BasketDTO.class));

		} catch (Exception e) {
			System.out.println("getBasketList Error!: " + e);
		}

		return list;
	}

	public int basketRemove(String user_id, String cookie_name) {
		String sql = "delete from basket where user_id =? AND cookie_name=?";
		int result = 0;

		try {

			result = template.update(sql, user_id, cookie_name);

		} catch (Exception e) {
			System.out.println("BasketRemove Error! : " + e);
		}

		return result;

	}

	public void removeAll(String user_id) {
		String sql = "delete from basket where user_id =?";
		int result = 0;
		System.out.println("removeAll 이상무!");
		try {
			result = template.update(sql, user_id);

		} catch (Exception e) {
			System.out.println("BasketRemove Error! : " + e);
		}

	}

}