package com.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.*;

import com.DB.DBUse;
import com.entity.Signature;;

public class SignatureDao {
	public void saveSignature(Signature signature)throws Exception{
		Connection conn =DBUse.getConn();
		Statement stmt = DBUse.getStmt(conn);
		String sql = "insert into signature(sig_name,sig_content,creation_date,creator) values" + "(?,?,?,?)";
		
		PreparedStatement pstmt = DBUse.getPrepStmt(conn, sql);
		
		pstmt.setString(1,signature.getSig_name());
		pstmt.setString(2, signature.getSig_content());
		pstmt.setDate(3, new Date(signature.getCreation_date().getTime()));
		pstmt.setString(4,signature.getCreator());		
		pstmt.executeUpdate();
		DBUse.close(stmt);
		DBUse.close(pstmt);
	    DBUse.close(conn);   
		
	}

}
