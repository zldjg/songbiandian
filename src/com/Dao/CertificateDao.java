package com.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.DB.DBUse;
import com.entity.Certificate;;

public class CertificateDao {
	public void saveCertificate(Certificate certificate)throws Exception{
		Connection conn =DBUse.getConn();
		Statement stmt = DBUse.getStmt(conn);
		String sql = "insert into certificate(name,sex,age,birthdate,cer_type,issue_office,issue_date,validity) values" + "(?,?,?,?,?,?,?,?)";
		
		PreparedStatement pstmt = DBUse.getPrepStmt(conn, sql);
		
		pstmt.setString(1,certificate.getName());
		pstmt.setString(2, certificate.getSex());
		pstmt.setInt(3, certificate.getAge());
		pstmt.setDate(4, new Date(certificate.getBirthdate().getTime()));
	    pstmt.setString(5,certificate.getCer_type());
	    pstmt.setString(6, certificate.getIssue_office());
	    pstmt.setDate(7, new Date(certificate.getIssue_date().getTime()));
	    pstmt.setDate(8, new Date(certificate.getValidity().getTime()));		
		pstmt.executeUpdate();
		DBUse.close(stmt);
		DBUse.close(pstmt);
	    DBUse.close(conn);   
		
	}


}
