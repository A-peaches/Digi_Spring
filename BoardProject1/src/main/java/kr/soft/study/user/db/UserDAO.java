package kr.soft.study.user.db;


import java.sql.*;

import javax.naming.*;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.util.*;

public class UserDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	DataSource ds;
	public UserDAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/MysqlDB");
			
			//con = ds.getConnection();
			System.out.println("DB Connect Success!");
		} catch (Exception ex) {
			System.out.println("DB Connect Fail " + ex);
			return;
		}
	}
	public boolean addMember(UserDTO joinData) {
		int result = 0;
		
		String sql = "insert into userInfo (user_id, user_name, user_pw, user_email, birth, hobby, info) values"
				+ "(?,?,?,?,?,?,?)";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,joinData.getUser_id());
			pstmt.setString(2, joinData.getUser_name());
			pstmt.setString(3, joinData.getUser_pw());
			pstmt.setString(4, joinData.getUser_email());
			pstmt.setString(5, joinData.getBirth());
			pstmt.setString(6, joinData.getHobby());
			pstmt.setString(7, joinData.getInfo());
			
			result = pstmt.executeUpdate();
			if(result ==0) return false;
			
			return true;
		} catch (SQLException e) {
			System.out.println("addMember Error!: "+ e);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
			}
			if(con != null)
				try {
					con.close();
				} catch(SQLException ex) {
					
			}
		}

	
		return false;
	}
	public boolean loginCheck(String user_id, String user_pw) {
		String sql = "Select user_id, isadmin from userInfo where user_id = ? AND user_pw = ?";
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_pw);
			
			rs = pstmt.executeQuery();
			rs.next();
		
			if(rs.getString(1).equals(user_id)) {
				return true;
			}
			
			
		} catch(SQLException ex){
			System.out.println("loginCheck Error! : "+ex);
		}finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
			}
			if(con != null)
				try {
					con.close();
				} catch(SQLException ex) {
					
			}
		}

		return false;
	}
	public UserDTO getUserInfo(String user_id) {
		String sql = "select * from userInfo where user_id = ?";
		UserDTO loginData = new UserDTO();
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				loginData.setUser_id(rs.getString("user_id"));
				loginData.setUser_pw(rs.getString("user_pw"));
				loginData.setUser_email(rs.getString("user_email"));
				loginData.setUser_name(rs.getString("user_name"));
				loginData.setBirth(rs.getString("birth"));
				loginData.setHobby(rs.getString("hobby"));
				loginData.setInfo(rs.getString("info"));
				loginData.setIsadmin(rs.getBoolean("isadmin"));
			} else {
				System.out.println("User is null");
				return null;
			}
			
			return loginData;
			
		} catch(SQLException ex){
			System.out.println("loginCheck Error! : "+ex);
		}finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
			}
			if(con != null)
				try {
					con.close();
				} catch(SQLException ex) {
					
			}
		}
		return null;
	}
	public boolean adminCheck(String user_id) {
		String sql = "select isadmin from userInfo where user_id = ?";
		UserDTO loginData = new UserDTO();
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				return rs.getBoolean(1);
			} else {
				System.out.println("It's not Admin.");
				return false;
			}
			
			
		} catch(SQLException ex){
			System.out.println("loginCheck Error! : "+ex);
		}finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
			}
			if(con != null)
				try {
					con.close();
				} catch(SQLException ex) {
					
			}
		}
		return false;
	}
	
	public ArrayList<UserDTO> getMemberList() {
		String sql = "select * from userInfo where isadmin=0";
		ArrayList<UserDTO> list = new ArrayList<UserDTO>();
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
	
			while(rs.next()) {
				UserDTO loginData = new UserDTO();
				loginData.setUser_id(rs.getString("user_id"));
				loginData.setUser_pw(rs.getString("user_pw"));
				loginData.setUser_email(rs.getString("user_email"));
				loginData.setUser_name(rs.getString("user_name"));
				loginData.setBirth(rs.getString("birth"));
				loginData.setHobby(rs.getString("hobby"));
				loginData.setInfo(rs.getString("info"));
				loginData.setIsadmin(rs.getBoolean("isadmin"));
				list.add(loginData);
			}
			
			return list;
			
		} catch (SQLException ex) {
			System.out.println("loginCheck Error! : " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {

				}
		}

		return null;
	}
	public int memberDelete(String user_id) {
		String sql = "delete from userInfo where user_id =?";
		int result = 0;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			
			result = pstmt.executeUpdate();

			return result;
			
		} catch (SQLException e) {
			System.out.println("MemberDelete Error! : " + e);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {

				}
		}
		
		return result;
	}

}
	
