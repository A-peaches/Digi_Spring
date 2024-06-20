package kr.soft.study.dto;

public class Cookie {
	private String cookie_name;
	private int cookie_price;
	private int cookie_cnt;

	public Cookie() {

	}

	public Cookie(String cookie_name, int cookie_price, int cookie_cnt) {
		this.cookie_name = cookie_name;
		this.cookie_price = cookie_price;
		this.cookie_cnt = cookie_cnt;
	}

	public String getCookie_name() {
		return cookie_name;
	}

	public void setCookie_name(String cookie_name) {
		this.cookie_name = cookie_name;
	}

	public int getCookie_price() {
		return cookie_price;
	}

	public void setCookie_price(int cookie_price) {
		this.cookie_price = cookie_price;
	}

	public int getCookie_cnt() {
		return cookie_cnt;
	}

	public void setCookie_cnt(int cookie_cnt) {
		this.cookie_cnt = cookie_cnt;
	}

}
