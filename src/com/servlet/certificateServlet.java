package com.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.CertificateDao;
import com.entity.Certificate;

public class certificateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		  
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		Integer age = Integer.parseInt(request.getParameter("age"));
		String date1 = request.getParameter("birthdate");
		String cer_type = request.getParameter("cer_type");
		String issue_office=request.getParameter("issue_office");
		String date2 = request.getParameter("issue_date");
		String date3 = request.getParameter("validity");
				
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date birthdate = new Date();
		Date issue_date = new Date();
		Date validity = new Date();
		try {		
			birthdate = sdf.parse(date1);
			issue_date = sdf.parse(date2);
			validity = sdf.parse(date3);
			
		} catch (ParseException e) {		
			e.printStackTrace();	
		}	
		
		Certificate certificate = new Certificate();
		certificate.setName(name);
		certificate.setSex(sex);
		certificate.setAge(age);
		certificate.setBirthdate(birthdate);
		certificate.setCer_type(cer_type);
		certificate.setIssue_office(issue_office);
		certificate.setIssue_date(issue_date);
		certificate.setValidity(validity);
				
		CertificateDao cd = new CertificateDao();		
		
		try{
			cd.saveCertificate(certificate);
		}catch(Exception e){
			e.printStackTrace();
		}
			
				
		RequestDispatcher rd = request.getRequestDispatcher("/Zhengshu_new.jsp");
		rd.forward(request, response);
		
		 
	}
}
