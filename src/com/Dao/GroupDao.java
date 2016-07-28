package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBUse;
import com.entity.Managroup;
import com.entity.User;


public class GroupDao {
	
	
	public List<Managroup> getGroup() throws Exception{
		String sql = "select * from managroup ";
		List<Managroup> managroups = getGroups(sql);
		return managroups;
	}
	
	public List<Managroup> getGroups(String sql) throws Exception{
		List<Managroup> managroups = new ArrayList<Managroup>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Managroup managroup = null;
		try{
			conn = DBUse.getConn();
			stmt = DBUse.getStmt(conn);
			rs = DBUse.executeQuery(stmt, sql);
		 while(rs.next()){
			 managroup = new Managroup();
			 managroup.setGroup_id(rs.getInt(1));
			 managroup.setGroupname(rs.getString(2));
			 managroup.setDescriptor(rs.getString(3));
			 managroup.setAuthority(rs.getString(4));
			 managroup.setState(rs.getInt(5));
			 managroups.add(managroup);
		 }
		}catch(Exception e){
			throw new Exception();
		}finally{
			DBUse.close(rs);
			DBUse.close(stmt);
			DBUse.close(conn);
		}
		
		return managroups;
		
	}
		
	public void saveGroup(Managroup managroup)throws Exception{
		Connection conn =DBUse.getConn();
		Statement stmt = DBUse.getStmt(conn);
		String sql = "insert into managroup(groupname,descriptor,authority,state) values" + "(?,?,?,?)";
		
		PreparedStatement pstmt = DBUse.getPrepStmt(conn, sql);
		pstmt.setString(1,managroup.getGroupname());
		pstmt.setString(2,managroup.getDescriptor());
		pstmt.setString(3,managroup.getAuthority());
		pstmt.setInt(4, managroup.getState());
		
		pstmt.executeUpdate();
		DBUse.close(stmt);
		DBUse.close(pstmt);
	    DBUse.close(conn); 
	}
	
	public int getGroupId(String groupname)throws Exception{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int groupid = 0;
		String sql = "select group_id from managroup where groupname ='" + groupname+"'";
		Managroup managroup = null;
		try{
			conn = DBUse.getConn();
			stmt = DBUse.getStmt(conn);
			rs = DBUse.executeQuery(stmt, sql);
			while(rs.next()){
				managroup = new Managroup();
				managroup.setGroup_id(rs.getInt(1));
			}
			groupid = managroup.getGroup_id();
	}catch(Exception e){
		throw new Exception();
	}finally{
		DBUse.close(rs);
		DBUse.close(stmt);
		DBUse.close(conn);
	}
	
	return groupid;
	}
	
	public void deleteGroup(int[] group_id)throws Exception{
		Connection conn =DBUse.getConn();
		Statement stmt = DBUse.getStmt(conn);
		
		try{
			for(int i =0;i<group_id.length;i++){
			stmt.executeUpdate("delete from managroup where  =" + group_id[i]);
			}
		}catch (Exception e) {
			throw new Exception();
		} finally {
			DBUse.close(stmt);
			DBUse.close(conn);
		}

		
	}
	
	public void createGuanlian(int group_id,int[] menu_id)throws Exception{
		Connection conn =DBUse.getConn();
		Statement stmt = DBUse.getStmt(conn);
		try{
			for(int i=0;i<menu_id.length;i++){
				stmt.executeUpdate("insert into gm_relate(group_id,menu_id) values ("+group_id + ","+menu_id[i]+")");
			}
		}catch (Exception e) {
			throw new Exception();
		} finally {
			DBUse.close(stmt);
			DBUse.close(conn);
		}
		
	}
	public void deleteGuanlianById(int id)throws Exception{
		Connection conn =DBUse.getConn();
		Statement stmt = DBUse.getStmt(conn);
		try{
			
			stmt.executeUpdate("delete from gm_relate where group_id =" + id);
			
		}catch (Exception e) {
			throw new Exception();
		} finally {
			DBUse.close(stmt);
			DBUse.close(conn);
		}
		
		
	}
	public Managroup getGroupById(String id) throws Exception{
		String sql = "select * from managroup where group_id = " + id;
		Managroup managroup = getGroup(sql);
		return managroup;
		
	}
	
	public Managroup getGroup(String sql) throws Exception{
		
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Managroup managroup = new Managroup();
		
		try{
			conn = DBUse.getConn();
			stmt = DBUse.getStmt(conn);
			rs = DBUse.executeQuery(stmt, sql);
			while(rs.next()){
			managroup = new Managroup();
			managroup.setGroup_id(rs.getInt(1));
			managroup.setGroupname(rs.getString(2));
			managroup.setDescriptor(rs.getString(3));
			managroup.setAuthority(rs.getString(4));
			managroup.setState(rs.getInt(5));
						
			 			
			}
		}catch(Exception e){
			throw new Exception();
		}finally{
			DBUse.close(rs);
			DBUse.close(stmt);
			DBUse.close(conn);
		}
		
		return managroup;
		
	}
	
public void updateManagroup(Managroup managroup) throws Exception{
		
		Connection conn = DBUse.getConn();
		Statement stmt = DBUse.getStmt(conn);
		String sql = "update managroup set groupname=?, descriptor=?, authority=?, state=? where group_id = ?";
		PreparedStatement pstmt = DBUse.getPrepStmt(conn, sql);
		ResultSet rs = null;

		try {
			pstmt.setString(1, managroup.getGroupname());
			pstmt.setString(2, managroup.getDescriptor());
			pstmt.setString(3, managroup.getAuthority());
			pstmt.setInt(4, managroup.getState());
			pstmt.setInt(5, managroup.getGroup_id());
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

}
