package com.Dao;


import java.sql.*;
import com.entity.*;
import com.DB.*;


import java.util.List;
import java.util.ArrayList;

public class UserDao {
	
	public List<User> getUser() throws Exception{
		String sql = "select * from user";
		List<User> users = getUsers(sql);
		return users;
	}
	public List<User> getUsers(String sql) throws Exception{
		
		List<User> users = new ArrayList<User>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		User user = null;
		try{
			conn = DBUse.getConn();
			stmt = DBUse.getStmt(conn);
			rs = DBUse.executeQuery(stmt, sql);
		 while(rs.next()){
			 user = new User();
			 user.setUserid(rs.getInt(1));
			 user.setName(rs.getString(2));
			 user.setUsername(rs.getString(3));
			 user.setPassword(rs.getString(4));
			 user.setGroup(rs.getString(5));
			 user.setRank(rs.getString(6));
			 user.setPhonenumber(rs.getString(7));
			 user.setMobilephone(rs.getString(8));
			 user.setEmail(rs.getString(9));
			 user.setState(rs.getInt(10));
			 
			 users.add(user);
		 }
		}catch(Exception e){
			throw new Exception();
		}finally{
			DBUse.close(rs);
			DBUse.close(stmt);
			DBUse.close(conn);
		}
		
		return users;
		
	}
public User getUser(String sql) throws Exception{
		
				
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		User user = new User();
		
		try{
			conn = DBUse.getConn();
			stmt = DBUse.getStmt(conn);
			rs = DBUse.executeQuery(stmt, sql);
			while(rs.next()){
			 user = new User();
			 user.setUserid(rs.getInt(1));
			 user.setName(rs.getString(2));
			 user.setUsername(rs.getString(3));
			 user.setPassword(rs.getString(4));
			 user.setGroup(rs.getString(5));
			 user.setRank(rs.getString(6));
			 user.setPhonenumber(rs.getString(7));
			 user.setMobilephone(rs.getString(8));
			 user.setEmail(rs.getString(9));
			 user.setState(rs.getInt(10));
			 			
			}
		}catch(Exception e){
			throw new Exception();
		}finally{
			DBUse.close(rs);
			DBUse.close(stmt);
			DBUse.close(conn);
		}
		
		return user;
		
	}
	
	public boolean valid(String username, String password) throws Exception{
		boolean isValid = false;
		String sql = "select * from user where username='"+username+"' and password='"+password+"'";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
				
		try{
			conn = DBUse.getConn();
			stmt = DBUse.getStmt(conn);
			rs = DBUse.executeQuery(stmt, sql);
		if(rs.next()){
			isValid = true;
		}
		}catch(Exception e){
			throw new Exception();
		}finally{
			DBUse.close(rs);
			DBUse.close(stmt);
			DBUse.close(conn);
			
		}
			
				return isValid;	
		}
	public void saveUser(User user)throws Exception{
		Connection conn =DBUse.getConn();
		Statement stmt = DBUse.getStmt(conn);
		String sql = "insert into user(name,username,password,groupname,rank,phonenumber,mobilephone,email,state) values" + "(?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement pstmt = DBUse.getPrepStmt(conn, sql);
		
		pstmt.setString(1,user.getName());
		pstmt.setString(2,user.getUsername());
		pstmt.setString(3,user.getPassword());
		pstmt.setString(4, user.getGroup());
		pstmt.setString(5,user.getRank());
		pstmt.setString(6, user.getPhonenumber());
		pstmt.setString(7, user.getMobilephone());
		pstmt.setString(8,user.getEmail());
		pstmt.setInt(9, user.getState());
		
		pstmt.executeUpdate();
		DBUse.close(stmt);
		DBUse.close(pstmt);
	    DBUse.close(conn);   
		
	}
	
	public void deleteUser(int[] userid)throws Exception{
		Connection conn =DBUse.getConn();
		Statement stmt = DBUse.getStmt(conn);
		
		try{
			for(int i =0;i<userid.length;i++){
			stmt.executeUpdate("delete from user where userid =" + userid[i]);
			}
		}catch (Exception e) {
			throw new Exception();
		} finally {
			DBUse.close(stmt);
			DBUse.close(conn);
		}

		
	}
	public User getUserById(String id) throws Exception{
		String sql = "select * from user where userid = " + id;
		User user = getUser(sql);
		return user;
		
	}
	public void updateUser(User user) throws Exception{
		
		Connection conn = DBUse.getConn();
		Statement stmt = DBUse.getStmt(conn);
		String sql = "update user set name=?, username=?, password=?, groupname=?, rank=?, phonenumber=?, mobilephone=?, email=?, state=? where userid = ?";
		PreparedStatement pstmt = DBUse.getPrepStmt(conn, sql);
		ResultSet rs = null;

		try {
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getUsername());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getGroup());
			pstmt.setString(5, user.getRank());
			pstmt.setString(6, user.getPhonenumber());
			pstmt.setString(7, user.getMobilephone());
			pstmt.setString(8, user.getEmail());
			pstmt.setInt(9, user.getState());
			pstmt.setInt(10, user.getUserid());
			pstmt.executeUpdate();

		} catch (Exception e) {
			throw new Exception();
		} finally {
			DBUse.close(rs);
			DBUse.close(stmt);
			DBUse.close(pstmt);
			DBUse.close(conn);
		}
		
	}
	
	public ShowRecordByPage getUsersByPage(int pageNow, int pageSize) throws Exception {

		ShowRecordByPage page = new ShowRecordByPage();

		page.setPageNow(pageNow);
		page.setPageSize(pageSize);

		int startPos = (pageNow * pageSize) - pageSize ;
		
		String sql = "select * from user limit " +startPos+","+pageSize;
		

		List<User> user = getUsers(sql);
		page.setDatas(user);

		return page;
	}
		
		
}

