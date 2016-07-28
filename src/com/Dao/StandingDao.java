package com.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.DB.DBUse;
import com.entity.Standing;

public class StandingDao {
	public void saveStanding(Standing standing)throws Exception{
		Connection conn =DBUse.getConn();
		Statement stmt = DBUse.getStmt(conn);
		String sql = "insert into standing(bel_unit,erp_cord,sto_unit,custodian,equ_sort1,equ_sort2,equ_name,equ_cord,equ_add,item_number,standard,equ_condition,equ_number,measurement,manufacturer,m_date,examine_date,maturity,is_mature,remark) values" + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement pstmt = DBUse.getPrepStmt(conn, sql);
		
		pstmt.setString(1,standing.getBel_unit());
		pstmt.setString(2,standing.getErp_cord());
		pstmt.setString(3, standing.getSto_unit());
		pstmt.setString(4, standing.getCustodian());
		pstmt.setString(5, standing.getEqu_sort1());
		pstmt.setString(6, standing.getEqu_sort2());
		pstmt.setString(7, standing.getEqu_name());
		pstmt.setString(8, standing.getEqu_cord());
		pstmt.setString(9, standing.getEqu_add());
		pstmt.setString(10, standing.getItem_number());
		pstmt.setString(11, standing.getStandard());
		pstmt.setString(12, standing.getEqu_condition());
		pstmt.setString(13, standing.getEqu_number());
		pstmt.setString(14, standing.getMeasurement());
		pstmt.setString(15, standing.getManufacturer());
		pstmt.setDate(16, new Date(standing.getM_date().getTime()));
		pstmt.setDate(17, new Date(standing.getExamine_date().getTime()));
		pstmt.setDate(18, new Date(standing.getMaturity().getTime()));
		pstmt.setString(19, standing.getStandard());
		pstmt.setString(20, standing.getRemark());
		pstmt.executeUpdate();
		DBUse.close(stmt);
		DBUse.close(pstmt);
	    DBUse.close(conn);   
		
	}


}
