package com.DB;

import java.sql.*;

public class DBUse {
	
	private DBUse(){};
	
	public static Connection getConn()throws SQLException{
		Connection conn =null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/electrical_measurement_mis", "root","0226" );
		}catch(ClassNotFoundException e){
			throw new SQLException("数据库连接驱动异常");
		}catch(SQLException e){
			throw new SQLException("数据操作异常");
		}
		return conn;
	}
	public static Statement getStmt(Connection conn)throws SQLException{
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			
		}catch(SQLException e){
			throw new SQLException("Statement异常");
		}
		return stmt;
	}

	public static PreparedStatement getPrepStmt(Connection conn,String sql)throws SQLException{
		PreparedStatement pstmt = null;
		try{
			pstmt =conn.prepareStatement(sql);
		}catch (SQLException e){
			throw new SQLException("PreparedStatement异常");
		}
		return pstmt;
	}
	
	public static ResultSet executeQuery(Statement stmt,String sql)throws Exception{
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}
	public static void close(Connection conn)throws SQLException{
		if(conn !=null){
			try{
				conn.close();
				conn = null;
			}catch (SQLException e){
				throw new SQLException("关闭连接异常");
			}
		}
	}
	public static void close(Statement stmt) throws SQLException{
		if(stmt != null){
			try{
				stmt.close();
				stmt = null;
			}catch(SQLException e){
				throw new SQLException("Statement关闭异常");
			}
		}
	}
	public static void close(PreparedStatement pstmt)throws SQLException{
		if(pstmt != null){
			try{
				pstmt.close();
				pstmt = null;
			}catch (SQLException e){
				throw new SQLException("PreparedStatement关闭异常");
			}
		}
	}
	public static void close(ResultSet rs)throws SQLException{
		if(rs != null){
			try{
				rs.close();
				rs = null;
			}catch (SQLException e){
				throw new SQLException("ResultSet关闭异常");
			}
		}
	}
}
