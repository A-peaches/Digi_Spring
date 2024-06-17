package kr.soft.study.member;

public class JoinData {
	private String id;
	private String pw;
	private String pw2;
	private String email;
	private String name;
	private String idNo;
	private int year;
	private int month;
	private int day;
	private String habit;
	private String myInfo;
	
	
	public String getPw2() {
		return pw2;
	}

	public void setPw2(String pw2) {
		this.pw2 = pw2;
	}

	public JoinData() {
		
	}
	
	public JoinData(String id, String pw, String email, String name, String idNo, int year, int month, int day,
			String habit, String myInfo) {
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.name = name;
		this.idNo = idNo;
		this.year = year;
		this.month = month;
		this.day = day;
		this.habit = habit;
		this.myInfo = myInfo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getHabit() {
		return habit;
	}
	public void setHabit(String habit) {
		this.habit = habit;
	}
	public String getMyInfo() {
		return myInfo;
	}
	public void setMyInfo(String myInfo) {
		this.myInfo = myInfo;
	}
}
